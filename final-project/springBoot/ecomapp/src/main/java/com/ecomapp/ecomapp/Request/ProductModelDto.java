package com.ecomapp.ecomapp.Request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
public class ProductModelDto {
    Integer product_id;
    Integer cart_id;
    Integer qty;
    String name;
    Double price;
    Integer category_id;
    Integer is_available;
    Double discount;
    String description;
    LocalDate created_date;

}
