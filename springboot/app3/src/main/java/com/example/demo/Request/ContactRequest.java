package com.example.demo.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequest {
    Long id;
    String name,phoneNo,email,message,created_on;
}
