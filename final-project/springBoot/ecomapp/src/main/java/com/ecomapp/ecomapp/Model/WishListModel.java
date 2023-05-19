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
@Table(name="wish_list")
public class WishListModel {
   @Id
   Integer id;
   Integer user_id,product_id;

   @Column(updatable = false,insertable = false)
   LocalDate created_date;
}
