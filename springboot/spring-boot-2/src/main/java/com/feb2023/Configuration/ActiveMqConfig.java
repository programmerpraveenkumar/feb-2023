package com.feb2023.Configuration;

import com.feb2023.service.SampleService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;

import javax.jms.ConnectionFactory;
@Configuration
public class ActiveMqConfig {
    Logger logger = LoggerFactory.getLogger(ActiveMqConfig.class);

//    @Value("${spring.activemq.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public BrokerService broker() throws Exception {
//        final BrokerService broker = new BrokerService();
//        broker.addConnector("tcp://localhost:61616");
//        broker.setBrokerName("broker1");
//        broker.setUseJmx(false);
//        return broker;
//    }

//    @Bean
//    public BrokerService broker2() throws Exception {
//        final BrokerService broker = new BrokerService();
//        broker.addConnector("tcp://localhost:61616");
//        broker.setBrokerName("broker2");
//        broker.setUseJmx(false);
//        return broker;
//    }
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
//        activeMQConnectionFactory.setUserName("admin");
//        activeMQConnectionFactory.setPassword("admin");
//        return  activeMQConnectionFactory;
//    }
////
//    @Bean
//    public JmsTemplate jmsTemplate(){
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory());
//        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
//        return jmsTemplate;
//    }
@JmsListener(destination = "mar2023")
public void onMessage(Message message) {
    try{
        ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
        //    log.info("Received Message: "+ message.getBody(String.class));
        logger.info("Received Message: "+ objectMessage.getText());

        //call the userservice
    } catch(Exception e) {
        logger.error("Received Exception : "+ e);
    }
}
}
