package com.feb2023.Configuration;

import com.feb2023.Response.GeneralResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> ExceptionHandlingforRuntimeException(RuntimeException e){
        System.out.println("inside Exception for RuntimeException handler "+e.getMessage());
        GeneralResponse response = new GeneralResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> ExceptionHandlingForCustomException(CustomException e){
        //based on the error can send email to the team for fixing the issue
        System.out.println("inside Custom Exception exception handler "+e.getMessage());
        GeneralResponse response = new GeneralResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
