package com.example.demo.Request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter

@Setter
public class BusinessActionRequest {
    Integer id;
    String title,description;

}
