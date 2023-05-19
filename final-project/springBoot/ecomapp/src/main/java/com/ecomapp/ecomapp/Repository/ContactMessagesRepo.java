package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Model.ContactMessagesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessagesRepo extends JpaRepository<ContactMessagesModel,Integer> {

}
