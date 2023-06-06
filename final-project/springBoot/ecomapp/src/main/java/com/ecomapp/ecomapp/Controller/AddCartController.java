package com.ecomapp.ecomapp.Controller;

import com.ecomapp.ecomapp.Request.AddCartModelDTO;
import com.ecomapp.ecomapp.Service.AddCartService;
import com.ecomapp.ecomapp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "*")
public class AddCartController {
    @Autowired
    AddCartService addCartService;
    @Autowired
    OrderService orderService;
    @PostMapping("save")
    public ResponseEntity<?> saveAddCart(@RequestBody AddCartModelDTO addCartModelDTO){
        try{
            addCartService.saveAddCart(addCartModelDTO);
            return ResponseEntity.ok("");//sucsess reponse.
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error "+e.getMessage());//errr resopnse.
        }
    }
    @PostMapping("orderComplete")
    public ResponseEntity<?> saveAddCart(@RequestBody HashMap<String,String> orderMap){
        try{
            Integer user_id = Integer.parseInt(orderMap.get("user_id"));
            orderService.completedOrder(user_id,orderMap.get("address"));
            return ResponseEntity.ok("");//sucsess reponse.
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error "+e.getMessage());//errr resopnse.
        }
    }

    @GetMapping("getByUserId/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(addCartService.getUserById(userId));
    }
}
