package com.service2.service2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("service2")
public class sampleController {
    @GetMapping("test")
    public ResponseEntity sampleResponse(){
        return ResponseEntity.ok(Arrays.asList("service2-1","service2-2"));
    }
}
