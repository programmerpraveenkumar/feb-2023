package com.example.demo.service;

import com.example.demo.Repository.BusinessActionRepo;
import com.example.demo.Repository.ContactRepo;
import com.example.demo.Request.BusinessActionRequest;
import com.example.demo.Request.ContactRequest;
import com.example.demo.model.BusinessActionModel;
import com.example.demo.model.ContactModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SampleService {

    Logger logger = LoggerFactory.getLogger(SampleService.class);
    @Autowired
    BusinessActionRepo businessActionRepo;
    @Autowired
    ContactRepo contactRepo;

public List<BusinessActionModel> getBusinessAction(){
    return businessActionRepo.findAll();
}
    public List<ContactModel> getAllContactMessages(){
        return contactRepo.findAll();
    }

    public void saveContactMessage(ContactRequest contactRequest){
             ContactModel contactModel = ContactModel.builder()
                                    .name(contactRequest.getName())
                                    .message(contactRequest.getMessage())
                                    .email(contactRequest.getEmail())
                                    .phoneNo(contactRequest.getPhoneNo()).build();
            contactRepo.save(contactModel);
    }
    public void saveBusinessActionRequest(BusinessActionRequest businessActionRequest){
       BusinessActionModel businessActionModel= new BusinessActionModel();
       businessActionModel.setDescription(businessActionRequest.getDescription());
       businessActionModel.setTitle(businessActionRequest.getTitle());
       businessActionRepo.save(businessActionModel);
    }
    public void deleteBusinessRequest(BusinessActionRequest businessActionRequest){
        businessActionRepo.deleteById(businessActionRequest.getId());
    }

}
