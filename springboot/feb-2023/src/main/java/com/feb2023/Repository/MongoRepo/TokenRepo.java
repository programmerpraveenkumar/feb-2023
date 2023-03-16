package com.feb2023.Repository.MongoRepo;

import com.feb2023.model.MongoModels.TokenModel;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface TokenRepo extends MongoRepository<TokenModel, ObjectId> {
    @Query("{'userid' : ?0}")
    Optional<TokenModel> findByUserid(Integer userid);
}
