package com.feb2023.controller;


import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RestController
public class SimpleController {

    @GetMapping("name")//localhost:8080/name
    public String getName(){
        return "sample name";
    }
    @GetMapping("getUser")//localhost:8080/name
    public String getAge(@RequestParam String pageNo){
        return "Page no is "+pageNo;
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
    @PostMapping("login")
    public ResponseEntity loginValidation(@RequestBody  UserRequest userRequest){
        GeneralResponse generalResponse = new GeneralResponse();
        if(userRequest.getEmail().equals("admin@gmail.com") && userRequest.getPassword().equals("admin")){
            generalResponse.setMessage("Login is ok");
            return ResponseEntity.ok(generalResponse);//success response
           // return "login is ok ";
        }else{
            generalResponse.setMessage("Please provide the proper details.");
            return ResponseEntity.badRequest().body(generalResponse);//failure reponse.
         //  return "Please provide the proper details.";
        }
        //return userRequest.getName()+" "+userRequest.getAddress()+" "+userRequest.getEmail();
    }
}
