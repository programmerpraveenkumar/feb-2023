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
@Table(name="addCart")
public class AddCartModel {
    @Id
    Integer cart_id;
    Integer user_id;
    Integer product_id;
    Integer qty;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
