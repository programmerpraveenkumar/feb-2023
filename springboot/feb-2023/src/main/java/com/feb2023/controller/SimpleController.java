package com.feb2023.controller;


 import com.feb2023.Configuration.CustomException;
 import com.feb2023.Request.EmailContent;
import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.Response.UserServerResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
 import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.jms.annotation.JmsListener;

 import org.springframework.util.FileCopyUtils;
 import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


 import javax.servlet.http.HttpServletResponse;
 import java.io.BufferedInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.InputStream;
 import java.math.BigDecimal;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.util.Arrays;
import java.util.List;


/*
@RestController->return the json response.it will not return html or webpages.
@Controller->return the json or html also.
localhost:8080/login
localhost:8080/register
localhost:8080/listuser
getmapping->not for sensitive data,file upload cannot be done.

postmapping
    login or register,
    good for sensitive data.
    fileupload can be done.
    requestbody can be sent.

putmapping
    for update can use this mapping.instead of this can use post also
patch
    for updating the single field,can use this mapping,.instead of this can use post or put
delete
    for delete the data.instead of this can use post also
 */

/*
C->create (insert)
R->reading the data (select)
U->update the data (update)
D->delete the data(delete)
 */
@RestController
public class SimpleController {
    @Autowired
    SampleService sampleService;//create the object for service class.

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    private static String UPLOADED_FOLDER = "/Volumes/softwares/projects/upload_folder/";

    //    @Autowired
//    private JavaMailSender emailSender;
    @GetMapping("countryname")
    public String getFromApplicationProps(){
        String value = environment.getProperty("COUNTRY_NAME");
        if(value.equals("uk")){
            return "united kingdom";
        }
        if(value.equals("uae")){
            return "dubai";
        }
        return  environment.getProperty("COUNTRY_NAME");
    }


    @GetMapping("name")//localhost:8080/name
    public String getName(){
        return "sample name";
    }
//    @GetMapping("getUser")//localhost:8080/name
//    public String getAge(@RequestParam String pageNo){
//        return "Page no is "+pageNo;
//    }
    @GetMapping("getUser")//localhost:8080/name
    public ResponseEntity<?> getUseLists(){
        try{
            List<UserModel> user = sampleService.getUser();
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new GeneralResponse("Error in api "+e.getMessage()));
        }

    }
    @GetMapping("getUser/email")//localhost:8080/name
    public ResponseEntity<?> getUseList(@RequestParam String email){
        try{
             UserModel user = sampleService.getUser(email);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new GeneralResponse("Error in api"+e.getMessage()));
        }

    }

    @GetMapping("testupdate")
    public ResponseEntity<String> update(){
        sampleService.updateNameByid("tetname",5);
        return ResponseEntity.ok("udpate ");
    }
    @PostMapping("otpValidate")
    public String storeUser(@RequestParam String otp){
        System.out.println("OTP "+otp);
        return otp;
    }

    @PostMapping("user/{id}")
    public String pathVariable(@PathVariable String id){
        return "user id "+id;
    }
    @GetMapping("user/{id}")
    public String pathVariableGET(@PathVariable String id){
        return "user id "+id;
    }
    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody  UserRequest userRequest)throws Exception {
            UserModel userModel = sampleService.registerUser(userRequest);
            return ResponseEntity.ok(userModel);

    }
    @DeleteMapping("deleteUser/{type}")
    public ResponseEntity deleteUserById(@RequestBody  UserRequest userRequest,@PathVariable String type,@RequestHeader String user_id)throws Exception{
            GeneralResponse generalResponse = new GeneralResponse();
            //check the header userid with request userid
            if(!user_id.equals(userRequest.getUserId())){
                throw new Exception("Don't have permission to update the user details");
            }
            sampleService.deleteUser(type,""+userRequest.getUserId());
            generalResponse.setMessage("User is deleted");
            return ResponseEntity.ok(generalResponse);

    }
    @PutMapping("updateUserById")
    public ResponseEntity updateUserById(@RequestBody  UserRequest userRequest,@RequestHeader String user_id)throws Exception{
            if(!user_id.equals(""+userRequest.getUserId())){
                throw new Exception("Don't have permission to update the user details");
            }
           UserModel userModel =  sampleService.updateUserByid(userRequest);
            return ResponseEntity.ok(userModel);

    }
    @PutMapping("updateUserByEmail")
    public ResponseEntity updateUserByEmail(@RequestBody  UserRequest userRequest)throws Exception{

            UserModel userModel =  sampleService.updateUserByEmail(userRequest);
            return ResponseEntity.ok(userModel);

    }

    @PostMapping("login")
    public ResponseEntity loginValidation(@RequestBody  UserRequest userRequest)throws Exception{
            logger.info("inside login validation");
           UserModel userModel =  sampleService.login(userRequest.getEmail(),userRequest.getPassword());
            return ResponseEntity.ok(userModel);

        //return userRequest.getName()+" "+userRequest.getAddress()+" "+userRequest.getEmail();
    }
    @PostMapping("logout")
    public ResponseEntity logout(@RequestHeader String user_id)throws Exception{
            GeneralResponse generalResponse = new GeneralResponse();
            sampleService.logout(Integer.parseInt(user_id));
            generalResponse.setMessage("logout successful");
            return ResponseEntity.ok(generalResponse);
    }
    @PostMapping("sendEmail")
    public ResponseEntity sendEmail(@RequestBody EmailContent request)throws Exception{



        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("Email sent");
        return ResponseEntity.ok(generalResponse);
    }

    @GetMapping("getUserListFromAnotherServer")
    public ResponseEntity getUserListFromAnotherServer()throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Chrome/54.0.2840.9");
//        headers.add("token", "token value");
//        headers.add("user_id", "user_id value");
        //headers.setAccept();
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        UserServerResponse response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET,entity, UserServerResponse.class).getBody();
        logger.info(response.getData().toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("testactivemq")
    public ResponseEntity<?> sendMessage(@RequestParam String message) throws Exception{


        sampleService.publishMessage(message);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("message sent");
        return ResponseEntity.ok(generalResponse);
    }
    @JmsListener(destination = "mar2023")
    public void onMessage(Message message) {
        try{
            ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
            //    log.info("Received Message: "+ message.getBody(String.class));
            logger.info("Received Message: "+ objectMessage.getText());

            //call the userservice
        } catch(Exception e) {
            logger.error("Received Exception : "+ e);
        }
    }
    @GetMapping("testmongodb")
    public ResponseEntity<?> printUserListFromMongo() throws Exception{
        List<com.feb2023.model.MongoModels.UserModel> userModelList = sampleService.printUserListFromMongo();
        return ResponseEntity.ok(userModelList);
    }
    @PostMapping("createUserMongo")
    public ResponseEntity<?> createUserMongo(@RequestBody UserRequest userRequest)throws Exception{
        sampleService.insertUserInMongo(userRequest);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("Register ok");
        return ResponseEntity.ok(generalResponse);
    }
    @GetMapping("deleteUserMongo")
    public ResponseEntity<?> deleteById(@RequestParam String id)throws Exception{
        ObjectId idObj = new ObjectId(id);
        sampleService.deleteById(idObj);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("user Deleted");
        return ResponseEntity.ok(generalResponse);
    }

    @PostMapping("updateUserMongo")
    public ResponseEntity<?> userUpdateById(@RequestBody UserRequest userRequest)throws Exception{
        sampleService.userUpdateByIdMongodb(userRequest);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("User is updated!!!");
        return ResponseEntity.ok(generalResponse);
    }

    @GetMapping("testcache")
    public ResponseEntity testcache(@RequestParam Long number){
        BigDecimal squareval =  sampleService.square(number);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(""+squareval);
        return ResponseEntity.ok(generalResponse);
    }

    @PostMapping("fileupload")
    public ResponseEntity<?> fileupload(@RequestParam MultipartFile file)throws CustomException {
            try{
                logger.error("inside the file upload ");

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);//write the file into the location.

                GeneralResponse generalResponse = new GeneralResponse();
                generalResponse.setMessage("File Name is uploaded success"+file.getOriginalFilename());
                return ResponseEntity.ok(generalResponse);
             }catch (Exception e){
                logger.error("Error while upload ",e.getMessage());
                throw new CustomException("Error while upload "+e.getMessage());
            }
    }
    @GetMapping("filename/{imgName}")
    public void getImage(HttpServletResponse response, @PathVariable String imgName)throws CustomException {
        try{
            logger.error("inside the file upload ");
            File file = new File(UPLOADED_FOLDER +imgName);
            if(!file.exists()){
                file = new File(UPLOADED_FOLDER +"no-image.jpg");
            }
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }catch (Exception e){
            logger.error("Error while upload ",e.getMessage());
            throw new CustomException("Error while upload "+e.getMessage());
        }
    }

}
