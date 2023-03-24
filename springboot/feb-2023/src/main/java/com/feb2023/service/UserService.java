package com.feb2023.service;

import com.feb2023.Configuration.CustomException;
import com.feb2023.Repository.CountryRepo;
import com.feb2023.Repository.MongoRepo.TokenRepo;
import com.feb2023.Repository.MongoRepo.UserRepoMongo;
import com.feb2023.Repository.UserRepo;
import com.feb2023.Request.UserRequest;
import com.feb2023.model.AddressModel;
import com.feb2023.model.CountryModel;
import com.feb2023.model.MongoModels.TokenModel;
import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CountryRepo countryRepo;
    @Autowired
    UserRepoMongo userRepoMongo;
    @Autowired
    TokenRepo tokenRepo;

    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(SampleService.class);
    public List<UserModel> getUser(){
        return userRepo.findAll();//get all the data.
    }
    @Cacheable(value = "userCache",key = "#email")
    public UserModel getUser(String email) throws CustomException {
        logger.info("get user in service");
        Userids userids = new Userids();
        userids.setEmail(email);
        return userRepo.findByEmail(email).stream().findAny().orElseThrow(()->new CustomException("User not found"));
        //return userRepo.findById(userids).orElseThrow(()->new Exception("User not found"));

    }

    public List<com.feb2023.model.MongoModels.UserModel> printUserListFromMongo(){
        return userRepoMongo.findAll();//get all the data from the mongoddb user's collection.
    }

    public void updateNameByid(String name,Integer id){
        userRepo.updateNameById(name,id);
    }

    public  boolean loginValidation(UserRequest userRequest)throws Exception{
        if(userRequest.getEmail().equals("admin@gmail.com")
                && userRequest.getPassword().equals("admin")){
            return true;

        }else{
            throw new Exception("Error in userRequest");
        }
    }
    public boolean deleteUser(String type,String value)throws CustomException{
        UserModel user = null;
        Userids userid  = new Userids();

        if(type.equals("email")){
            userid.setEmail(value);
            //   user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
        }else if(type.equals("id")){
            //userid.setId(Integer.parseInt(value));
            user   = getUserById(value);
            //userRepo.findById(Integer.parseInt(value)).orElseThrow(()->new Exception("User is not found"));
        }

        // user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
        userRepo.delete(user);
        return true;
    }
    public  UserModel registerUser(UserRequest userRequest)throws CustomException{
        //email validation
        if(userRepo.findByEmail(userRequest.getEmail()).stream().count() > 0){
            throw new CustomException("email is already exist");
        }
        if(!Objects.nonNull(userRequest.getEmail())){
            throw new CustomException("Email should not be empty");
        }else if(!Objects.nonNull(userRequest.getName())){
            throw new CustomException("Name should not be empty");
        }else if(!Objects.nonNull(userRequest.getPassword())){
            throw new CustomException("Password should not be empty");
        }else{
            CountryModel countryModel = countryRepo.findById(userRequest.getCountryId()).orElseThrow(()->new CustomException("Country is not found"));
//            Userids userids = new Userids();
//            userids.setMobile(userRequest.getMobile());
//            userids.setEmail(userRequest.getEmail());
            //register in the database.
            UserModel userModel = new UserModel();
            //userModel.setAddress(userRequest.getAddress());
            userModel.setName(userRequest.getName());
            //userModel.setUserids(userids);
            //userModel.setEmail();
            userModel.setEmail(userRequest.getEmail());
            userModel.setPassword(userRequest.getPassword());
            userModel.setMobile(userRequest.getMobile());
            userModel.setDob(userRequest.getDob());
            userModel.setCountryModel(countryModel);
            List<AddressModel> addressModels = this.getUserAddressList(userRequest.getAddress());

//            AddressModel addressModel1 = new AddressModel();
//            addressModel1.setType("temp");
//            addressModel1.setAddress("sample address");
//            userModel.setAddressModel(addressModels);
//
//            AddressModel addressModel2 = new AddressModel();
//            addressModel2.setType("temp");
//            addressModel2.setAddress("sample address");
//            addressModels.add(addressModel1);
//            addressModels.add(addressModel2);

            //userModel.setAddressModel(addressModels);
            userRepo.save(userModel);//insert the data in database.
            return userModel;
        }
    }

    public UserModel login(String email,String password)throws  CustomException{
        try{
            // UserModel user = getUser(email);
            UserModel userModel = userRepo.login(email,password).orElseThrow(()->new CustomException("Email or Password  is wrong"));
            String token = createToken(email);
            logger.info("token is generated for login");
            tokenUpdateForUser(userModel.getId(),token);//update token for mysql and mongo
            //  userRepo.updateTokenById();//update the token in the table for user
            userModel.setToken(token);//assing the token in the user Model.
            logger.info("inside login validation {} ",userModel.getId());
            return userModel;
        }catch (Exception e){
            this.sendEmailNotifationWhileLoginFailure(email);
            throw new CustomException(e.getMessage());//response to UI.
        }
    }
    private void tokenUpdateForUser(Integer userId,String token){
        userRepo.updateTokenById(token,userId);//update the token in the mysql table for user
        Optional<TokenModel> tokenModelOpt = tokenRepo.findByUserid(userId);//mongodb
        TokenModel tokenModel = new TokenModel();
        logger.info("update in mongodb");
        //existing user
        if(tokenModelOpt.isPresent()){
            logger.info("update in mongodb");
            tokenModel = tokenModelOpt.get();
        }else{
            tokenModel.setUserid(userId);
        }
        tokenModel.setToken(token);
        tokenRepo.save(tokenModel);
        logger.info("token update complete for {} ",userId);
    }
    private void sendEmailNotifationWhileLoginFailure(String email){
        try{
            UserModel user = getUser(email);
            this.sendEmail(email,"Filed Login attempt notification ","<h1>Filed login notification</h1>");
        }catch (Exception e){
            logger.info("While sending loginfailed notification"+e.getMessage());
        }

    }
    private List<AddressModel> getUserAddressList(List<AddressModel> list){
        List<AddressModel> listAddress = new ArrayList<>();
        list.forEach(address->{
            AddressModel addressModel = new AddressModel();
            addressModel.setType(address.getType());
            addressModel.setAddress(address.getAddress());
            listAddress.add(addressModel);
        });
        return listAddress;
    }
    public  UserModel updateUserByEmail(UserRequest userRequest)throws CustomException{
//        Userids userids = new Userids();
//        userids.setEmail(userRequest.getEmail());
        //return null;
        UserModel userModel = userRepo.findByEmail(userRequest.getEmail()).stream().findFirst().orElseThrow(()->new CustomException("User is not found"));
        userModel = this.updateUser(userModel,userRequest);
        return  userModel;

    }
    public UserModel updateUserByid(UserRequest userRequest)throws CustomException {
        Userids userids = new Userids();
        userids.setId(userRequest.getUserId());
        UserModel userModel = getUserById(userRequest.getUserId());
        userModel = this.updateUser(userModel,userRequest);
        return  userModel;

    }
    public void updateProfilePicture(String imgName,Integer userId){
        userRepo.profilePicUpdate(imgName,userId);
    }
    private  UserModel updateUser(UserModel userModel,UserRequest userRequest)throws CustomException{

        if(Objects.nonNull(userRequest.getEmail())){
            userModel.setEmail(userRequest.getEmail());
        } if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        } if(Objects.nonNull(userRequest.getPassword())){
            userModel.setPassword(userRequest.getPassword());
        } if(Objects.nonNull(userRequest.getMobile())){
            userModel.setMobile(userRequest.getMobile());
        } if(Objects.nonNull(userRequest.getAddress())){
            //userModel.setAddress(userRequest.getAddress());
        } if(Objects.nonNull(userRequest.getDob() )){
            userModel.setDob(userRequest.getDob());
        }
        userRepo.save(userModel);//update the data in database.
        this.sendEmail(userModel.getEmail(),"Update Notification","<h1>Hi User,Your Details are updated.Please let us know if it is not you.</h1>");
        //email notification for user
        return userModel;
    }

    private String createToken(String email){
        long JWT_TOKEN_VALIDITY = 24 * 60 * 60;//24hours
        //   long JWT_TOKEN_VALIDITY = 2;//2secs
        String token =  Jwts.builder().setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("JWT_SECRET")).compact();
        return token;
    }
    private void tokenDecode(String token)throws CustomException{
        try {
            Jwts.parser()
                    .setSigningKey(environment.getProperty("JWT_SECRET"))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | ClassCastException e) {
            throw new CustomException(e.getMessage());
        }
    }
    public List<UserModel> getUserList(){
        return userRepo.findAll();
    }
    public List<UserModel> userListNotLoggedIn(){
        return userRepo.userNotLoggedIn();
    }

    public void logout(Integer userId)throws Exception{

        tokenUpdateForUser(userId,"");
        //userRepo.updateTokenById("",userModel.getId());

    }
    private UserModel getUserById(String userId)throws CustomException{
        return getUserById(Integer.parseInt(userId));
    }
    public UserModel getUserById(Integer userId)throws CustomException{
        return   userRepo.findById(userId).orElseThrow(()->new CustomException("User is not found"));
    }

    public boolean validateTokenAgainstTheUser(String token,String userId)throws CustomException{
        this.tokenDecode(token);
        //mongod token validation.
        Optional<TokenModel> userOpt = tokenRepo.findByUserid(Integer.parseInt(userId));
        if(userOpt.isPresent()){
            logger.info("user is  exist in mongodb ");
            if(userOpt.get().getToken().equals(token)){
                logger.info("token match in mongodb");
                return true;
            }else{
                logger.info("token not match in mongodb..so goes to Mysql {} ",userId);
                return mysqlUserTokenVerifcation(token,userId);
            }
        }else {
            logger.info("user is not exist in mongodb so goes to Mysql");
            return mysqlUserTokenVerifcation(token,userId);

        }
        //return false;
    }
    private boolean mysqlUserTokenVerifcation(String token,String userId)throws CustomException{
        UserModel userModel = getUserById(userId);
        if (userModel.getToken() == null || !userModel.getToken().equals(token)) {
            logger.error("Token mismatch in mysql ");
            throw new CustomException("Token mismatch");
        } else {
            logger.info("token  match   Mysql {} ",userId);
            return true;
        }
    }
    public boolean sendEmail(String toAddress,String subject,String bodyContent)throws CustomException{
        try{
            String fromAddress = "contact@gmail.com";
            String host = "localhost";//or IP address
            //Get the session object
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session session = Session.getDefaultInstance(properties);
            //compose the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
            message.setSubject(subject);
            //message.setText(request.getMessage());
            message.setContent("<html><head></head><body>"+bodyContent+"</body></html","text/html");
            // Send message
            Transport.send(message);
            return true;
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }

    }
    public void publishMessage(String message)throws Exception{

        jmsTemplate.convertAndSend("mar2023",message);
//            jmsTemplate.send("mar2023", new MessageCreator() {
//            public javax.jms.Message createMessage(javax.jms.Session session) throws JMSException {
//                TextMessage txtMsg = session.createTextMessage();
//                txtMsg.setText(message);
//                return txtMsg;
//            }
//        });
    }

    public void insertUserInMongo(UserRequest userRequest)throws Exception{
        com.feb2023.model.MongoModels.UserModel userModel =new com.feb2023.model.MongoModels.UserModel();
        userModel.setDob(userRequest.getDob().toString());
        userModel.setEmail(userRequest.getEmail());
        userModel.setMobile(userRequest.getMobile());
        userRepoMongo.save(userModel);
    }
    public void deleteById(ObjectId userId)throws Exception{
        com.feb2023.model.MongoModels.UserModel userModel = userRepoMongo.findById(userId).orElseThrow(()->new Exception("No User Found"));
        userRepoMongo.delete(userModel);
    }
    public void userUpdateByIdMongodb(UserRequest userRequest)throws Exception{
        ObjectId objId = new ObjectId(userRequest.getUserIdStr());
        com.feb2023.model.MongoModels.UserModel userModel = userRepoMongo.findById(objId).orElseThrow(()->new Exception("No User Found"));
        if(Objects.nonNull(userRequest.getEmail())) {
            userModel.setEmail(userRequest.getEmail());
        }if(Objects.nonNull(userRequest.getMobile())){
            userModel.setMobile(userRequest.getMobile());
        }if(Objects.nonNull(userRequest.getDob() )){
            userModel.setDob(userRequest.getDob().toString());
        }
        userRepoMongo.save((userModel));//existing user update.
    }
    //@Cacheable(value = "squareCache",key = "#number",condition = "#number>10")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
        logger.info("square of {} is {}", number, square);
        return square;
    }

}
