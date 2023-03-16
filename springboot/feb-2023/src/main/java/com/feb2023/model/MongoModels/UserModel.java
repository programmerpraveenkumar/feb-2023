package com.feb2023.model.MongoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.feb2023.model.AddressModel;
import com.feb2023.model.CountryModel;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document("user")
public class UserModel {
    @Id
    ObjectId id;
    String mobile;
    String email;
    String dob;
    String token;
}

