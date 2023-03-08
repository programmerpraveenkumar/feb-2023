package com.feb2023.Request;

import com.feb2023.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserRequest {
    Integer userId;
    String name;
    String email;
    String mobile;
  //  String address;
    String password;
    LocalDate dob;
    Integer countryId;
    List<AddressModel> address;

}
