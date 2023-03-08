package com.feb2023.Repository;

import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{
    @Query("select user from UserModel user where email = ?1")
    List<UserModel> findByEmail(String email);
    @Query("select user from UserModel user where token is null")
    List<UserModel> userNotLoggedIn();
    @Query("select user from UserModel user where email = ?1 and password = ?2")
    Optional<UserModel> login(String email, String password);
    @Transactional
    @Modifying
    @Query("update UserModel user set  user.name = ?1 where id = ?2")
    void updateNameById(String name,Integer id);

    @Transactional
    @Modifying
    @Query("update UserModel user set  user.token = ?1 where id = ?2")
    void updateTokenById(String token,Integer id);

}
