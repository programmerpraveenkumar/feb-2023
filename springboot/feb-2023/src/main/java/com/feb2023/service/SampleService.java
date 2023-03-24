package com.feb2023.service;

import com.feb2023.Configuration.ActiveMqConfig;
import com.feb2023.Configuration.CustomException;
import com.feb2023.Repository.CountryRepo;
import com.feb2023.Repository.MongoRepo.TokenRepo;
import com.feb2023.Repository.MongoRepo.UserRepoMongo;
import com.feb2023.Repository.UserRepo;
import com.feb2023.Request.UserRequest;

import com.feb2023.controller.SimpleController;
import com.feb2023.model.AddressModel;
import com.feb2023.model.CountryModel;
import com.feb2023.model.MongoModels.TokenModel;
import com.feb2023.model.UserModel;
import com.feb2023.model.Userids;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;
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
        UserRepoMongo userRepoMongo;
        @Autowired
        TokenRepo tokenRepo;
        @Autowired
        UserService userService;

    @Autowired
    JmsTemplate jmsTemplate;
        @Autowired
        Environment environment;

    Logger logger = LoggerFactory.getLogger(SampleService.class);




      public  boolean loginValidation(UserRequest userRequest)throws Exception{
            if(userRequest.getEmail().equals("admin@gmail.com")
                    && userRequest.getPassword().equals("admin")){
                return true;

            }else{
               throw new Exception("Error in userRequest");
            }
      }
      public boolean deleteUser(String type,String value)throws CustomException{
            UserModel user = null;
            Userids userid  = new Userids();

            if(type.equals("email")){
                userid.setEmail(value);
            //   user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
            }else if(type.equals("id")){
                //userid.setId(Integer.parseInt(value));
                user   = userService.getUserById(Integer.parseInt(value));
                        //userRepo.findById(Integer.parseInt(value)).orElseThrow(()->new Exception("User is not found"));
            }

         // user = userRepo.findById(userid).orElseThrow(()->new Exception("User is not found"));
            userRepo.delete(user);
            return true;
      }




    public boolean sendEmail(String toAddress,String subject,String bodyContent)throws CustomException{
        try{
            String fromAddress = "contact@gmail.com";
            String host = "localhost";//or IP address
            //Get the session object
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session session = Session.getDefaultInstance(properties);
            //compose the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
            message.setSubject(subject);
            //message.setText(request.getMessage());
            message.setContent("<html><head></head><body>"+bodyContent+"</body></html","text/html");
            // Send message
            Transport.send(message);
            return true;
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }

    }
    public void publishMessage(String message)throws Exception{

        jmsTemplate.convertAndSend("mar2023",message);
//            jmsTemplate.send("mar2023", new MessageCreator() {
//            public javax.jms.Message createMessage(javax.jms.Session session) throws JMSException {
//                TextMessage txtMsg = session.createTextMessage();
//                txtMsg.setText(message);
//                return txtMsg;
//            }
//        });
    }


    //@Cacheable(value = "squareCache",key = "#number",condition = "#number>10")
    public BigDecimal square(Long number) {
        BigDecimal square = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
        logger.info("square of {} is {}", number, square);
        return square;
    }
}
