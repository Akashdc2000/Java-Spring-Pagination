package com.example.paginationdemo.repository;

import com.example.paginationdemo.entities.DatedUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatedUserRepository extends MongoRepository<DatedUser,String> {
}
