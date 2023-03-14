package com.feb2023.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feb2023.model.AddressModel;
import com.feb2023.model.CountryModel;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class LoginResponse {
    Integer id;
    String mobile;
    String email;
    String name,address;
    LocalDate dob;
    CountryModel countryModel;
    List<AddressModel> addressModel;
    String token;
}
