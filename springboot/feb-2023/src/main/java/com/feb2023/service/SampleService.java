package com.feb2023.service;

import com.feb2023.Repository.UserRepo;
import com.feb2023.Request.UserRequest;

import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import org.apache.catalina.User;
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
    public UserModel getUser(String email) throws  Exception{
            Userids userids = new Userids();
            userids.setEmail(email);
         return userRepo.findById(userids).orElseThrow(()->new Exception("User not found"));

    }

       public void updateNameByid(String name,Integer id){
                userRepo.updateNameById(name,id);
        }

      public  boolean loginValidation(UserRequest userRequest)throws Exception{
            if(userRequest.getEmail().equals("admin@gmail.com")
                    && userRequest.getPassword().equals("admin")){
                return true;

            }else{
               throw new Exception("Error in userRequest");
            }
      }
      public boolean deleteUser(String type,String value)throws Exception{
            UserModel user = null;
            Userids userid  = new Userids();

            if(type.equals("email")){
                userid.setEmail(value);
               user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
            }else if(type.equals("id")){
                userid.setId(Integer.parseInt(value));
                //user = userRepo.findById(Integer.parseInt(value)).orElseThrow(()->new Exception("User is not found"));
            }
          user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
            userRepo.delete(user);
            return true;
      }
    public  UserModel registerUser(UserRequest userRequest)throws Exception{
            //email validation
//        if(userRepo.findByEmail(userRequest.getEmail()).stream().count() > 0){
//            throw new Exception("email is already exist");
//        }
        if(!Objects.nonNull(userRequest.getEmail())){
            throw new Exception("Email should not be empty");
        }else if(!Objects.nonNull(userRequest.getName())){
            throw new Exception("Name should not be empty");
        }else if(!Objects.nonNull(userRequest.getPassword())){
            throw new Exception("Password should not be empty");
        }else{
            Userids userids = new Userids();
            userids.setMobile(userRequest.getMobile());
            userids.setEmail(userRequest.getEmail());
            //register in the database.
            UserModel userModel = new UserModel();
            userModel.setAddress(userRequest.getAddress());
            userModel.setName(userRequest.getName());
            userModel.setUserids(userids);
            userModel.setPassword(userRequest.getPassword());
            //userModel.setMobile(userRequest.getMobile());
            userModel.setDob(userRequest.getDob());
            userRepo.save(userModel);//insert the data in database.
            return userModel;
        }
    }
    public  UserModel updateUserByEmail(UserRequest userRequest)throws Exception{
        Userids userids = new Userids();
        userids.setEmail(userRequest.getEmail());
//        UserModel userModel = userRepo.findByEmail(userids).stream().findFirst().orElseThrow(()->new Exception("User is not found"));
//        userModel = this.updateUser(userModel,userRequest);
//        return  userModel;
        return null;
    }
    public UserModel updateUserByid(UserRequest userRequest)throws Exception{
            Userids userids = new Userids();
            userids.setId(userRequest.getUserId());
        UserModel userModel = userRepo.findById(userids).orElseThrow(()->new Exception("User is not found"));
        userModel = this.updateUser(userModel,userRequest);
        return  userModel;

    }
    private  UserModel updateUser(UserModel userModel,UserRequest userRequest)throws Exception{

        if(Objects.nonNull(userRequest.getEmail())){
           // userModel.setEmail(userRequest.getEmail());
        } if(Objects.nonNull(userRequest.getName())){
            userModel.setName(userRequest.getName());
        } if(Objects.nonNull(userRequest.getPassword())){
            userModel.setPassword(userRequest.getPassword());
        } if(Objects.nonNull(userRequest.getMobile())){
           // userModel.setMobile(userRequest.getMobile());
        } if(Objects.nonNull(userRequest.getAddress())){
            userModel.setAddress(userRequest.getAddress());
        } if(Objects.nonNull(userRequest.getDob() )){
            userModel.setDob(userRequest.getDob());
        }
        userRepo.save(userModel);//update the data in database.
        return userModel;
    }
}
