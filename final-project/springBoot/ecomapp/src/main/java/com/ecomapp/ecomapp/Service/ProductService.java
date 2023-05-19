package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.ProductModel;
import com.ecomapp.ecomapp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public List<ProductModel> getProductsByCategoryId(Integer categoryId){
        return productRepo.getProductsByCategoryId(categoryId);
    }
    public ProductModel getProductById(Integer productId)throws  Exception{
        return productRepo.findById(productId).orElseThrow(()->new Exception("No Product found"));
    }
}
