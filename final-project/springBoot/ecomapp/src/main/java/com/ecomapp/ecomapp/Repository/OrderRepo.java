package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Integer> {

}
