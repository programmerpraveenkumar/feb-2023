package com.feb2023.controller;


 import com.feb2023.Configuration.CustomException;
 import com.feb2023.Request.EmailContent;
import com.feb2023.Request.UserRequest;
import com.feb2023.Response.GeneralResponse;
import com.feb2023.Response.UserServerResponse;
import com.feb2023.model.UserModel;
import com.feb2023.service.SampleService;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
 import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.jms.annotation.JmsListener;

 import org.springframework.util.FileCopyUtils;
 import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


 import javax.servlet.http.HttpServletResponse;
 import java.io.BufferedInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.InputStream;
 import java.math.BigDecimal;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.util.Arrays;
import java.util.List;


/*
@RestController->return the json response.it will not return html or webpages.
@Controller->return the json or html also.
localhost:8080/login
localhost:8080/register
localhost:8080/listuser
getmapping->not for sensitive data,file upload cannot be done.

postmapping
    login or register,
    good for sensitive data.
    fileupload can be done.
    requestbody can be sent.

putmapping
    for update can use this mapping.instead of this can use post also
patch
    for updating the single field,can use this mapping,.instead of this can use post or put
delete
    for delete the data.instead of this can use post also
 */

/*
C->create (insert)
R->reading the data (select)
U->update the data (update)
D->delete the data(delete)
 */
@RestController
@RequestMapping("simple")
//@CrossOrigin(allowedHeaders = "*",origins = "*")
public class SimpleController {
    @Autowired
    SampleService sampleService;//create the object for service class.

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    private static String UPLOADED_FOLDER = "/Volumes/softwares/projects/upload_folder/";

    //    @Autowired
//    private JavaMailSender emailSender;
    @GetMapping("countryname")
    public String getFromApplicationProps(){
        String value = environment.getProperty("COUNTRY_NAME");
        if(value.equals("uk")){
            return "united kingdom";
        }
        if(value.equals("uae")){
            return "dubai";
        }
        return  environment.getProperty("COUNTRY_NAME");
    }


    @GetMapping("name")//localhost:8080/name
    public String getName(){
        return "sample name";
    }
//    @GetMapping("getUser")//localhost:8080/name
//    public String getAge(@RequestParam String pageNo){
//        return "Page no is "+pageNo;
//    }



    @GetMapping("testupdate")
    public ResponseEntity<String> update(){
        return ResponseEntity.ok("udpate ");
    }
    @PostMapping("otpValidate")
    public String storeUser(@RequestParam String otp){
        System.out.println("OTP "+otp);
        return otp;
    }

    @PostMapping("user/{id}")
    public String pathVariable(@PathVariable String id){
        return "user id "+id;
    }
    @GetMapping("user/{id}")
    public String pathVariableGET(@PathVariable String id){
        return "user id "+id;
    }


    @PostMapping("sendEmail")
    public ResponseEntity sendEmail(@RequestBody EmailContent request)throws Exception{



        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage("Email sent");
        return ResponseEntity.ok(generalResponse);
    }



    @GetMapping("testcache")
    public ResponseEntity testcache(@RequestParam Long number){
        BigDecimal squareval =  sampleService.square(number);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(""+squareval);
        return ResponseEntity.ok(generalResponse);
    }



    @PostMapping("fileupload")
    public ResponseEntity<?> fileupload(@RequestParam MultipartFile file)throws CustomException {
            try{
                logger.error("inside the file upload ");

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);//write the file into the location.

                GeneralResponse generalResponse = new GeneralResponse();
                generalResponse.setMessage("File Name is uploaded success"+file.getOriginalFilename());
                return ResponseEntity.ok(generalResponse);
             }catch (Exception e){
                logger.error("Error while upload ",e.getMessage());
                throw new CustomException("Error while upload "+e.getMessage());
            }
    }
    @GetMapping("filename/{imgName}")
    public void getImage(HttpServletResponse response, @PathVariable String imgName)throws CustomException {
        try{
            logger.error("inside the file upload ");
            File file = new File(UPLOADED_FOLDER +imgName);
            if(!file.exists()){
                file = new File(UPLOADED_FOLDER +"no-image.jpg");
            }
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }catch (Exception e){
            logger.error("Error while upload ",e.getMessage());
            throw new CustomException("Error while upload "+e.getMessage());
        }
    }

}
