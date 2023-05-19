package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.WishListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepo extends JpaRepository<WishListModel,Integer> {

}
