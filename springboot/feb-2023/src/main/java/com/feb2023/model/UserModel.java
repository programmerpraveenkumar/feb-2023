package com.feb2023.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel {
    @Id//MOdel should have one id.
    Integer id;
    String name,mobile,email,password,address,country;
    LocalDate dob;
}

