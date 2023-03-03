package com.feb2023.Configuration;

import com.feb2023.service.SampleService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {

    /*
        before reaching into the controller
        true->request will move to the controller
        false->stop the execution.
    */
    @Autowired
    SampleService sampleService;//create the object for service class.
    private Boolean isExcludeUrls(String url){
        url = url.replace("/","");
        System.out.println(url);
         List<String> urlEndpoints = Arrays.asList("login","register");
         return urlEndpoints.contains(url);
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle");
        String url = request.getRequestURI();
        if(isExcludeUrls(url)){
            return true;//move to the controller.
        }
        String token = request.getHeader("token");///get the token from the header
        String user_id = request.getHeader("user_id");///get the token from the header
        if(Objects.nonNull(token) ||Objects.nonNull(user_id)){
            sampleService.validateTokenAgainstTheUser(token,user_id);//throw exception.
            return true;
        }else{
           throw new Exception("token or userid is empty");
        }
    }



    //before sending the response to client.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //after sending the response to client.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
