package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.OrderModel;
import com.ecomapp.ecomapp.Repository.AddCartJPARepo;
import com.ecomapp.ecomapp.Repository.AddCartRepo;
import com.ecomapp.ecomapp.Repository.OrderRepo;

import com.ecomapp.ecomapp.Request.ProductModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    AddCartRepo addCartRepo;
    @Autowired
    AddCartJPARepo addCartJPARepo;
    /*
        insert into `order`(user_id,product_id,qty,price,address,status)select user_id,product_id,qty,10.5,'address','confirmed' from add_cart;

     */
    public Boolean completedOrder(Integer userId,String addressToDeliver){
        List<ProductModelDto>  productModelDtoList=  addCartRepo.getCartProductDetails(userId);
        orderRepo.completedOrder(productModelDtoList,userId,addressToDeliver);
        addCartJPARepo.deleteByUserId(userId);
        return  true;
    }
}
