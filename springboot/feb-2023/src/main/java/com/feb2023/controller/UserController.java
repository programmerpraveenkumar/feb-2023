package com.feb2023.controller;

import com.feb2023.Configuration.CustomException;
import com.feb2023.Request.EmailContent;
import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.Response.UserServerResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import com.feb2023.service.UserService;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("service3/user")
public class UserController {
    @Autowired
    UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private static String UPLOADED_FOLDER = "/Volumes/softwares/projects/upload_folder/";
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("getUser")//localhost:8080/name
    public ResponseEntity<?> getUseLists(){
        try{
            List<UserModel> user = userService.getUser();
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new GeneralResponse("Error in api "+e.getMessage()));
        }

    }
    @GetMapping("getUser/email")//localhost:8080/name
    public ResponseEntity<?> getUseList(@RequestParam String email){
        try{
            UserModel user = userService.getUser(email);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new GeneralResponse("Error in api"+e.getMessage()));
        }

    }





    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest)throws Exception {
        UserModel userModel = userService.registerUser(userRequest);
        return ResponseEntity.ok(userModel);

    }
    @DeleteMapping("deleteUser/{type}")
    public ResponseEntity deleteUserById(@RequestBody  UserRequest userRequest,@PathVariable String type,@RequestHeader String user_id)throws Exception{
        GeneralResponse generalResponse = new GeneralResponse();
        //check the header userid with request userid
        if(!user_id.equals(userRequest.getUserId())){
            throw new Exception("Don't have permission to update the user details");
        }
        userService.deleteUser(type,""+userRequest.getUserId());
        generalResponse.setMessage("User is deleted");
        return ResponseEntity.ok(generalResponse);

    }
    @PutMapping("updateUserById")
    public ResponseEntity updateUserById(@RequestBody  UserRequest userRequest,@RequestHeader String user_id)throws Exception{
        if(!user_id.equals(""+userRequest.getUserId())){
            throw new Exception("Don't have permission to update the user details");
        }
        UserModel userModel =  userService.updateUserByid(userRequest);
        return ResponseEntity.ok(userModel);

    }
    @PutMapping("updateUserByEmail")
    public ResponseEntity updateUserByEmail(@RequestBody  UserRequest userRequest)throws Exception{

        UserModel userModel =  userService.updateUserByEmail(userRequest);
        return ResponseEntity.ok(userModel);

    }

    @PostMapping("login")
    public ResponseEntity loginValidation(@RequestBody  UserRequest userRequest)throws Exception{
        logger.info("inside login validation");
        UserModel userModel =  userService.login(userRequest.getEmail(),userRequest.getPassword());
        return ResponseEntity.ok(userModel);

        //return userRequest.getName()+" "+userRequest.getAddress()+" "+userRequest.getEmail();
    }
    @PostMapping("logout")
    public ResponseEntity logout(@RequestHeader String user_id)throws Exception{
        GeneralResponse generalResponse = new GeneralResponse();
        userService.logout(Integer.parseInt(user_id));
        generalResponse.setMessage("logout successful");
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
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        UserServerResponse response = restTemplate.exchange("https://reqres.in/api/users?page=2", HttpMethod.GET,entity, UserServerResponse.class).getBody();
        logger.info(response.getData().toString());
        return ResponseEntity.ok(response);
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

    @PostMapping("createUserMongo")
    public ResponseEntity<?> createUserMongo(@RequestBody UserRequest userRequest)throws Exception{
        userService.insertUserInMongo(userRequest);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("Register ok");
        return ResponseEntity.ok(generalResponse);
    }
    @GetMapping("deleteUserMongo")
    public ResponseEntity<?> deleteById(@RequestParam String id)throws Exception{
        ObjectId idObj = new ObjectId(id);
        userService.deleteById(idObj);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("user Deleted");
        return ResponseEntity.ok(generalResponse);
    }

    @PostMapping("updateUserMongo")
    public ResponseEntity<?> userUpdateById(@RequestBody UserRequest userRequest)throws Exception{
        userService.userUpdateByIdMongodb(userRequest);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("User is updated!!!");
        return ResponseEntity.ok(generalResponse);
    }



    @PostMapping("picupload")
    public ResponseEntity<?> picupload(@RequestParam MultipartFile file, @RequestParam Integer userId)throws CustomException {
        try{
            logger.error("inside the file upload ");
            byte[] bytes = file.getBytes();
            String name = "img_"+System.currentTimeMillis()+".png";
            Path path = Paths.get(UPLOADED_FOLDER + name);
            Files.write(path, bytes);//write the file into the location.
            userService.updateProfilePicture(name,userId);//update in the database.
            GeneralResponse generalResponse = new GeneralResponse();
            generalResponse.setMessage("File Name is uploaded success"+file.getOriginalFilename());
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            logger.error("Error while upload ",e.getMessage());
            throw new CustomException("Error while upload "+e.getMessage());
        }
    }
    @GetMapping("downloadImageByUserId/{userId}")
    public void downloadImageByUserId(HttpServletResponse response, @PathVariable Integer userId)throws CustomException {
        try{
            //get the image name using userId
            UserModel userModel = userService.getUserById(userId);
            String imgName = userModel.getImg_name();

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
