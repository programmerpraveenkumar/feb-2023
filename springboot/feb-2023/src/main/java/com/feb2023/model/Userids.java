package com.feb2023.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter

@Embeddable
public class Userids implements Serializable {
    //@Id//Model should have one id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    Integer id;
    String mobile;
    String email;
}
