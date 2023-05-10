package com.feb2023.controller;


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


}
