package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel,Integer> {

}
