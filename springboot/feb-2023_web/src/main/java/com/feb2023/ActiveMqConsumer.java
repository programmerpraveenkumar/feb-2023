package com.feb2023;



import com.feb2023.service.SampleService;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.ObjectMessage;

@Configuration
public class ActiveMqConsumer {
    @Autowired
    SampleService sampleService;
    Logger log = LoggerFactory.getLogger(ActiveMqConsumer.class);


    @JmsListener(destination = "mar2023")
    public void onMessage(Message message) {
        try{
            ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
                    //    log.info("Received Message: "+ message.getBody(String.class));
            log.info("Received Message: "+ objectMessage.getText());
            sampleService.processMessage(objectMessage.getText());//send the data to service.
            //call the userservice
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
