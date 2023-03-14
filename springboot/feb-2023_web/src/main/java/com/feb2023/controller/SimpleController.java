package com.feb2023.controller;


import com.feb2023.Request.EmailContent;
import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.Response.LoginResponse;
import com.feb2023.Response.UserServerResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("about")
    public ModelAndView getAboutPage(){
        logger.info("inside the controller");
        ///database call and send the data to html
        return new ModelAndView("about");
    }
    @GetMapping("home")
    public ModelAndView homePage(){
        logger.info("home the controller");
        ///database call and send the data to html
        return new ModelAndView("home");
    }
    @GetMapping("contact")
    public ModelAndView contactPage(){
        logger.info("contact the controller");
        ///database call and send the data to html
        return new ModelAndView("contact");
    }
    @GetMapping("login")
    public ModelAndView login(){
        logger.info("contact the controller");
        ///database call and send the data to html
        return new ModelAndView("login");
    }
    @GetMapping("login_status")
    public ModelAndView login_response(@RequestParam String status){
        logger.info("login_response the controller {}",status);
        String message = status.equals("success")?"you are correct":"You are wrong";
        ModelAndView model = new ModelAndView();
        model.addObject("message",message);
        model.setViewName("login_ok");//pagename from the template folder
        return  model;//return the model
    }
    @GetMapping("userList")
    public ModelAndView userList(@RequestParam String  pageNo){
        ModelAndView model = new ModelAndView();
         model.setViewName("userList");
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Chrome/54.0.2840.9");
            HttpEntity <String> entity = new HttpEntity<String>(headers);
            UserServerResponse response = restTemplate.exchange("https://reqres.in/api/users?page="+pageNo,  HttpMethod.GET, entity,UserServerResponse.class).getBody();
            logger.info("userList response is {} {}",response.getData());
            model.addObject("userList",response.getData());
        }catch (Exception e){
            logger.error("Error in userList{}",e.getMessage());

        }
        return model;
    }
    @PostMapping("loginValidation")
    public String loginValidation(@RequestParam String email,@RequestParam String password,ModelAndView model){
        logger.info("contact the controller {} {}",email,password);
        model  = new ModelAndView("contact.html");
        HashMap<String,String> request = new HashMap<>();
        request.put("email",email);
        request.put("password",password);
        try{
            LoginResponse response = restTemplate.postForObject("http://localhost:8080/login",request, LoginResponse.class);
            logger.info("login response is {} {}",response.getId(),response.getToken());
        }catch (Exception e){
            logger.error("Error while login {}",e.getMessage());
            return "redirect:/login_status?status=fail";
        }

        ///database call and send the data to html
        //return new ModelAndView("contact.html");
        //return "contact.html";
        return "redirect:/login_status?status=success";
    }

}
