package com.ecomapp.ecomapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="user")
public class UserModel {
    @Id
    Integer user_id;
    String name;
    String email;
    String  password;
    String  mobile_no;
    String  city;
    String  street;
    String  address;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
