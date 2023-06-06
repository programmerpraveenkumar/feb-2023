package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.AddCartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AddCartJPARepo extends JpaRepository<AddCartModel,Integer> {
    @Query("select addCart from AddCartModel addCart where addCart.user_id = ?1")
    List<AddCartModel> findByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("delete  from AddCartModel  where user_id = ?1")
    void deleteByUserId(Integer userId);
}
