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
@Table(name="popular_products")
public class PopularProductModel {
    @Id
    Integer id;
    Integer product_id;
    @Column(updatable = false,insertable = false)
    LocalDate created_date;
}
