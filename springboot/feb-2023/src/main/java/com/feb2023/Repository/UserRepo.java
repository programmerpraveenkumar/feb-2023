package com.feb2023.Repository;

import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Userids>{
//    @Query("select user from UserModel user where email = ?1")
//    List<UserModel> findByEmail(String email);
    @Query("update UserModel user set  user.name = ?1 where id = ?2")
    void updateNameById(String name,Integer id);

}
