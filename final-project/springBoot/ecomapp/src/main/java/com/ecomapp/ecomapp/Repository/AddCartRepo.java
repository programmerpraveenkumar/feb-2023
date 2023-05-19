package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.AddCartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AddCartRepo extends JpaRepository<AddCartModel,Integer> {

}
