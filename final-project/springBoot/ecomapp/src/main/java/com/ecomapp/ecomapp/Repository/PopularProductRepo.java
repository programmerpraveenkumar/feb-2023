package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.PopularProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularProductRepo extends JpaRepository<PopularProductModel,Integer> {

}
