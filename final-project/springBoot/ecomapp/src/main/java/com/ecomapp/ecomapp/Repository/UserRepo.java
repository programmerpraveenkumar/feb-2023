package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {

}

