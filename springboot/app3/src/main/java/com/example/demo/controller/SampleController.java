package com.example.demo.controller;

import com.example.demo.Request.ContactRequest;
import com.example.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@CrossOrigin(origins = "*")
public class SampleController {
    @Autowired
    SampleService sampleService;
    @GetMapping("getBusinessAction")
    public ResponseEntity<?> getBusinessActins(){
        return ResponseEntity.ok(sampleService.getBusinessAction());
    }

    @PostMapping("saveContact")
    public ResponseEntity<?> saveContact(@RequestBody ContactRequest contactRequest){
        try{
            sampleService.saveContactMessage(contactRequest);
            return ResponseEntity.ok("");//200ok status code
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("");//400 status code.
        }

    }
}
