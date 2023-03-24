package com.feb2023.Configuration;


import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import com.feb2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class CronSchedulerConfig1 {
    @Autowired
    UserService userService;
//    @Scheduled(fixedRate = 5000)//each 5 second
//    //50*1000
//    public void printInConsole(){
//        List<UserModel> list = sampleService.userListNotLoggedIn();//gets the user who did not login
//        list.forEach(obj->{
//            System.out.println(obj.getName()+" "+obj.getEmail());
//        });
//        System.out.println("in scheduler"+ LocalDateTime.now());
//    }
  //  @Scheduled(cron="5 * * * * * ")//each 5 second
@Scheduled(cron="*/5 51 06 * * * ")//each 5 second
    public void printInConsole(){
        List<UserModel> list = userService.userListNotLoggedIn();//gets the user who did not login
        list.forEach(obj->{
            System.out.println(obj.getName()+" "+obj.getEmail());
        });
        System.out.println("in scheduler-2 "+ LocalDateTime.now());
    }

}
