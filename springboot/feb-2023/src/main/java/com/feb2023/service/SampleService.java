package com.feb2023.service;

import com.feb2023.Repository.CountryRepo;
import com.feb2023.Repository.UserRepo;
import com.feb2023.Request.UserRequest;

import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.*;

@Service
public class SampleService {
        @Autowired
        UserRepo userRepo;

        @Autowired
        CountryRepo countryRepo;



        @Autowired
        Environment environment;

    Logger logger = LoggerFactory.getLogger(SampleService.class);



}
