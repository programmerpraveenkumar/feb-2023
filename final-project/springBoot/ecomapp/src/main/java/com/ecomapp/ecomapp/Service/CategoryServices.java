package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.CategoryModel;
import com.ecomapp.ecomapp.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepo categoryRepo;

    public List<CategoryModel> getAllCategory(){
        return categoryRepo.findAll();
    }
}
