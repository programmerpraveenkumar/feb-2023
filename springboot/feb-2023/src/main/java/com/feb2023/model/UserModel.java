package com.feb2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel implements Serializable  {
    @Id//Model should have one id.
    @GeneratedValue(strategy =GenerationType.IDENTITY)//
    Integer id;
    String mobile;
    String email;
//    @EmbeddedId
//    Userids userids;

    String name,address;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    LocalDate dob;

    @OneToOne
    @JoinColumn(name = "country",referencedColumnName = "id")
    CountryModel countryModel;

    //TODO cache will not work..reslove this.
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    List<AddressModel> addressModel;

    String token;
}

