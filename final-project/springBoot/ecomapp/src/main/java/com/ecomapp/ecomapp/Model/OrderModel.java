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
@Table(name="order")
public class OrderModel {
    @Id
    Integer order_id;
    Integer user_id;
    Integer product_id;
    Integer qty;
    Integer price;
    String status;
    String address;
    String status_message;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;}
