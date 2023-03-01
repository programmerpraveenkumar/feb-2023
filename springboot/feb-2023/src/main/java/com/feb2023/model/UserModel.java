package com.feb2023.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel  {
//    @Id//Model should have one id.
//    @GeneratedValue(strategy =GenerationType.IDENTITY)//
//    Integer id;

    @EmbeddedId
    Userids userids;

    String name,password,address,country;

    LocalDate dob;
}

