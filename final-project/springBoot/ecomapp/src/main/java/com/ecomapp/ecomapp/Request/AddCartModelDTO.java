package com.ecomapp.ecomapp.Request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class AddCartModelDTO {
    Integer cart_id;
    Integer user_id;
    Integer product_id;
    Integer qty;
    LocalDate created_date;
}
