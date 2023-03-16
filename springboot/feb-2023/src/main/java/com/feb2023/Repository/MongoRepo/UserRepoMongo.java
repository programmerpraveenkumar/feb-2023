package com.feb2023.Repository.MongoRepo;

import com.feb2023.model.MongoModels.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoMongo extends MongoRepository<UserModel, ObjectId> {
}
