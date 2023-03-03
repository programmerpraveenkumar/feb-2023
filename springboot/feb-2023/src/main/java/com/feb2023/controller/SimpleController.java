package com.feb2023.controller;


import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity registerUser(@RequestBody  UserRequest userRequest) {
//        SampleService service  = new SampleService();
        try{
            UserModel userModel = sampleService.registerUser(userRequest);
            return ResponseEntity.ok(userModel);
        }catch (Exception e){
            GeneralResponse generalResponse = new GeneralResponse();
            generalResponse.setMessage("Error: "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
    @DeleteMapping("deleteUser/{type}")
    public ResponseEntity deleteUserById(@RequestBody  UserRequest userRequest,@PathVariable String type){
        GeneralResponse generalResponse = new GeneralResponse();
        try{
            sampleService.deleteUser(type,""+userRequest.getUserId());
            generalResponse.setMessage("User is deleted");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            generalResponse.setMessage("Error while deleting. "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
    @PutMapping("updateUserById")
    public ResponseEntity updateUserById(@RequestBody  UserRequest userRequest){
        GeneralResponse generalResponse = new GeneralResponse();
        try{
           UserModel userModel =  sampleService.updateUserByid(userRequest);
            return ResponseEntity.ok(userModel);
        }catch (Exception e){
            generalResponse.setMessage("Error while deleting. "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
    @PutMapping("updateUserByEmail")
    public ResponseEntity updateUserByEmail(@RequestBody  UserRequest userRequest){
        GeneralResponse generalResponse = new GeneralResponse();
        try{
            UserModel userModel =  sampleService.updateUserByEmail(userRequest);
            return ResponseEntity.ok(userModel);
        }catch (Exception e){
            generalResponse.setMessage("Error while deleting. "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }

    @PostMapping("login")
    public ResponseEntity loginValidation(@RequestBody  UserRequest userRequest){

        try{
           UserModel userModel =  sampleService.login(userRequest.getEmail(),userRequest.getPassword());
            return ResponseEntity.ok(userModel);
        }catch (Exception e){
            GeneralResponse generalResponse = new GeneralResponse();
            generalResponse.setMessage("Error while login. "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
        //return userRequest.getName()+" "+userRequest.getAddress()+" "+userRequest.getEmail();
    }
}
