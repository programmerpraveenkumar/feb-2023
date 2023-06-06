package com.ecomapp.ecomapp.Controller;

import com.ecomapp.ecomapp.Model.ProductModel;
import com.ecomapp.ecomapp.Repository.ProductRepo;
import com.ecomapp.ecomapp.Service.ProductService;
import com.ecomapp.ecomapp.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;


    @Test
    public void getProductByCategoryIdTest(){
        int categoryId = 1;
//        List<ProductModel> productModelList = new ArrayList<>();
//        productModelList.add(new ProductModel());
        ProductModel productModel = TestDataUtil.getProductModel();
        List<ProductModel> productModelList = Stream.of(productModel).collect(Collectors.toList());
        //System.out.println(productService);
       // when(productRepo.getProductsByCategoryId(categoryId)).thenReturn(productModelList);
        when(productService.getProductsByCategoryId(categoryId)).thenReturn(productModelList);//mocking the return result.
        HttpStatus statusCode =  productController.getProductByCategoryId(categoryId).getStatusCode();
        assertEquals(statusCode,HttpStatus.OK);
    }
    //Success response Test
    @Test
    public void getProductByIdTest()throws Exception{
        Integer productId = 1;
        ProductModel productModel = TestDataUtil.getProductModel();
        when(productService.getProductById(productId)).thenReturn(productModel);
       ResponseEntity<?> response =  productController.getProductById(productId);
       ProductModel productModelResponse = (ProductModel) response.getBody();
        HttpStatus statusCode =  response.getStatusCode();
        assertEquals(statusCode,HttpStatus.OK);
        assertEquals(productModel.getName(),productModelResponse.getName());
        assertEquals(productModel.getId(),productModelResponse.getId());
        assertEquals(productModel.getCategory_id(),productModelResponse.getCategory_id());
        assertEquals(productModel.getPrice(),productModelResponse.getPrice());

    }


    //Exception test
    @Test
    public void getProductByIdExceptionTest() throws Exception{
        Integer productId = 1;
        when(productService.getProductById(productId)).thenThrow(Exception.class);
        // ResponseEntity<ProductModel> response =  productController.getProductById(productId).getBody();
        HttpStatus statusCode =  productController.getProductById(productId).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST,statusCode);
    }
}
