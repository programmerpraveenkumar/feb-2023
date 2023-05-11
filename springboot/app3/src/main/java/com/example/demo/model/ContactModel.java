package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
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
