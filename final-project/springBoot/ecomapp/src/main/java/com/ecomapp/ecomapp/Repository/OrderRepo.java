package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.OrderModel;
import com.ecomapp.ecomapp.Request.ProductModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Repository
public class OrderRepo  {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    /*
        insert into `order`(user_id,product_id,qty,price,address,status)select user_id,product_id,qty,10.5,'address','confirmed' from add_cart;
;
     */
    public Boolean completedOrder(List<ProductModelDto> orderList,Integer user_id,String address){
        orderList.forEach(orderModelDto -> {
            Map<String, Object> params = new HashMap<>();
            params.put("user_id", user_id);
            params.put("product_id", orderModelDto.getProduct_id());
            params.put("qty", orderModelDto.getQty());
            params.put("price", orderModelDto.getPrice());
            params.put("address", address);
            params.put("status", "1");
            params.put("status_message", "confirmed");
            this.jdbcTemplate.update("insert into `order`(user_id,product_id,qty,price,address,status,status_message)values(:user_id,:product_id,:qty,:price,:address,:status,:status_message)",params);
        });


        return  true;
    }
}
