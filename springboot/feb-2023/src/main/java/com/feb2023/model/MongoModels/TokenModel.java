package com.feb2023.model.MongoModels;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("token")
public class TokenModel {
    @Id
    ObjectId id;
    Integer userid;
    String token;
}
