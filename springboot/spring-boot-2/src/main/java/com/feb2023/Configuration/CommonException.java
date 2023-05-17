package com.feb2023.Configuration;

import com.feb2023.Response.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
    Logger logger = LoggerFactory.getLogger(CommonException.class);


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> ExceptionHandlingforRuntimeException(RuntimeException e){
        logger.error("inside Exception for RuntimeException handler "+e.getMessage());
        GeneralResponse response = new GeneralResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> ExceptionHandlingForCustomException(CustomException e){
        //based on the error can send email to the team for fixing the issue
        logger.error("inside Custom Exception exception handler "+e.getMessage());
        GeneralResponse response = new GeneralResponse();
        response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
