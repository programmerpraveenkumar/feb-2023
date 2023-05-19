package com.ecomapp.ecomapp.Controller;

import com.ecomapp.ecomapp.Repository.ProductRepo;
import com.ecomapp.ecomapp.Service.CategoryServices;
import com.ecomapp.ecomapp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("get")
    public ResponseEntity<?> getProductByCategoryId(@RequestParam Integer categoryId){
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
    }
    @GetMapping("get/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        try{
            return ResponseEntity.ok(productService.getProductById(productId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("getFeaturedProducts")
    public ResponseEntity<?> getFeaturedProducts(){
        return ResponseEntity.ok("");
    }

}
