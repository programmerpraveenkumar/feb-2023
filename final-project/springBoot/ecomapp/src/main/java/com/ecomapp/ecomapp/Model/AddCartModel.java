package com.ecomapp.ecomapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="add_cart")
public class AddCartModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer cart_id;
    Integer user_id;
    Integer product_id;
    Integer qty;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
