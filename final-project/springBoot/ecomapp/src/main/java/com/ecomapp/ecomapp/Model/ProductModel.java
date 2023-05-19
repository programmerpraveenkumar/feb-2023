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
@Table(name="products")
public class ProductModel {
    @Id
    Integer id;
    String name;
    Double price;
    Integer category_id;
    Integer is_available;
    Double discount;
    String description;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
