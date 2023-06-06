package com.ecomapp.ecomapp;

import com.ecomapp.ecomapp.Model.ProductModel;
import com.ecomapp.ecomapp.Request.AddCartModelDTO;

import java.time.LocalDate;

public class TestDataUtil {

    public static ProductModel getProductModel(){
        ProductModel productModel = new ProductModel();
        productModel.setId(1);
        productModel.setCategory_id(1);
        productModel.setName("testname");
        productModel.setPrice(100.5);
        return productModel;
    }
    public static AddCartModelDTO getAddCartModelDTO(){
        AddCartModelDTO addCartModelDTO = new AddCartModelDTO();
        addCartModelDTO.setCart_id(1);
        addCartModelDTO.setQty(4);
        addCartModelDTO.setCreated_date(LocalDate.now());
        addCartModelDTO.setUser_id(1);
        return addCartModelDTO;
    }

}
