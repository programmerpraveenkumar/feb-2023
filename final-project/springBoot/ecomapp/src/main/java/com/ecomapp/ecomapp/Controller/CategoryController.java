package com.ecomapp.ecomapp.Controller;

import com.ecomapp.ecomapp.Service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;


    @GetMapping("get")
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok(categoryServices.getAllCategory());
    }

    @PostMapping("save")
    public ResponseEntity<?> saveCategory(){
        return ResponseEntity.ok(categoryServices.getAllCategory());
    }
}
