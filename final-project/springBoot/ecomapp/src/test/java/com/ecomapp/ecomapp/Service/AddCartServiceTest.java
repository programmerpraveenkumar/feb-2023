package com.ecomapp.ecomapp.Service;

import com.ecomapp.ecomapp.Model.AddCartModel;
import com.ecomapp.ecomapp.Repository.AddCartJPARepo;
import com.ecomapp.ecomapp.Repository.AddCartRepo;
import com.ecomapp.ecomapp.Request.AddCartModelDTO;
import com.ecomapp.ecomapp.Request.ProductModelDto;
import com.ecomapp.ecomapp.TestDataUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddCartServiceTest {
    @Mock
    AddCartJPARepo addCartJPARepo;
    @Mock
    AddCartRepo addCartRepo;

    @InjectMocks
    AddCartService addCartService;
    public void saveAddCartTest()throws Exception{
        AddCartModelDTO addCartModelDTO = TestDataUtil.getAddCartModelDTO();
        AddCartModel addCartModel = new AddCartModel();
        addCartModel.setQty(addCartModelDTO.getQty());
        addCartModel.setProduct_id(addCartModelDTO.getProduct_id());
        addCartModel.setUser_id(addCartModelDTO.getUser_id());
        when(addCartJPARepo.save(addCartModel)).thenReturn(addCartModel);
        Boolean status = addCartService.saveAddCart(addCartModelDTO);
        assertEquals(status,false);
    }
}
