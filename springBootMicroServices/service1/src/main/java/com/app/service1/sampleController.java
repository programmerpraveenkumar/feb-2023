package com.app.service1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("service1")
public class sampleController {
    @GetMapping("test")
    public ResponseEntity sampleResponse(){
        return ResponseEntity.ok(Arrays.asList("service1-1","service1-2"));
    }
}