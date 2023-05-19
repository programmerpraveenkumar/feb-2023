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
@Table(name="contact_messages")
public class ContactMessagesModel {
    @Id
    Integer id;
    String email, name, subject, message;

    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
