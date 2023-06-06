package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.ProductModel;
import com.ecomapp.ecomapp.Repository.ProductRepo;
import com.ecomapp.ecomapp.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;
    @InjectMocks
    ProductService productService;
    @Test
    public void getProductsByCategoryIdTest()throws  Exception{
        int categoryId = 1;
        ProductModel productModel = TestDataUtil.getProductModel();
        List<ProductModel> productModelList = Stream.of(productModel).collect(Collectors.toList());
        when(productRepo.getProductsByCategoryId(categoryId)).thenReturn(productModelList);
        List<ProductModel> productModelList1 = productService.getProductsByCategoryId(categoryId);
        assertEquals(productModelList.size(),productModelList1.size());
        //return productRepo.getProductsByCategoryId(categoryId);
    }
    @Test
    public void  getProductById()throws  Exception{
        int productId = 1;
        ProductModel productModel = TestDataUtil.getProductModel();
        when(productRepo.findById(productId)).thenReturn(Optional.of(productModel));
        ProductModel productModel1 = productService.getProductById(productId);
        assertEquals(productModel.getId(),productModel1.getId());
    }
}
