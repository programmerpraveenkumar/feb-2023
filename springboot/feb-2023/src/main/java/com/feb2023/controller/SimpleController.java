package com.feb2023.controller;


import com.feb2023.Configuration.TokenInterceptor;
import com.feb2023.Request.EmailContent;
import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.Response.UserServerResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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

           UserModel userModel =  sampleService.login(userRequest.getEmail(),userRequest.getPassword());
            return ResponseEntity.ok(userModel);

        //return userRequest.getName()+" "+userRequest.getAddress()+" "+userRequest.getEmail();
    }
    @PostMapping("logout")
    public ResponseEntity logout(@RequestHeader String user_id)throws Exception{
            GeneralResponse generalResponse = new GeneralResponse();
            sampleService.logout(user_id);
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
}
