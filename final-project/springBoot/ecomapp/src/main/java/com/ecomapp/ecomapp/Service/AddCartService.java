package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.AddCartModel;
import com.ecomapp.ecomapp.Repository.AddCartJPARepo;
import com.ecomapp.ecomapp.Repository.AddCartRepo;
import com.ecomapp.ecomapp.Request.AddCartModelDTO;
import com.ecomapp.ecomapp.Request.ProductModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddCartService {
    @Autowired
    AddCartJPARepo addCartJPARepo;
    @Autowired
    AddCartRepo addCartRepo;

    public List<ProductModelDto> getUserById(Integer userId){
           return addCartRepo.getCartProductDetails(userId);
    }
    //@Transactional
    public Boolean saveAddCart(AddCartModelDTO addCartModelDTO)throws Exception{
        AddCartModel addCartModel = new AddCartModel();
        addCartModel.setQty(addCartModelDTO.getQty());
        addCartModel.setProduct_id(addCartModelDTO.getProduct_id());
        addCartModel.setUser_id(addCartModelDTO.getUser_id());
        //store in multiple tables
        addCartJPARepo.save(addCartModel);
        return true;
    }
}
