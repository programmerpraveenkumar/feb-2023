package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer> {
    @Query("select product from ProductModel product where product.category_id=?1")
    List<ProductModel>getProductsByCategoryId(Integer categoryId);
}
