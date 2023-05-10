package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@Table(name="contact")
public class ContactModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String name,phoneNo,email,message;
    @Column(insertable = false,updatable = false)
    LocalDate created_on;
}
