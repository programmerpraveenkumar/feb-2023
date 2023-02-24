package com.feb2023.service;

import com.feb2023.Repository.UserRepo;
import com.feb2023.Request.UserRequest;

import com.feb2023.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SampleService {
        @Autowired
        UserRepo userRepo;

        public List<UserModel> getUser(){
            return userRepo.findAll();//get all the data.
        }

      public  boolean loginValidation(UserRequest userRequest)throws Exception{
            if(userRequest.getEmail().equals("admin@gmail.com")
                    && userRequest.getPassword().equals("admin")){
                return true;

            }else{
               throw new Exception("Error in userRequest");
            }
      }
    public  boolean registerUser(UserRequest userRequest)throws Exception{
        if(!Objects.nonNull(userRequest.getEmail())){
            throw new Exception("Email should not be empty");
        }else if(!Objects.nonNull(userRequest.getName())){
            throw new Exception("Name should not be empty");
        }else if(!Objects.nonNull(userRequest.getPassword())){
            throw new Exception("Password should not be empty");
        }else{
            //register in the database.
            return true;
        }
    }
}
