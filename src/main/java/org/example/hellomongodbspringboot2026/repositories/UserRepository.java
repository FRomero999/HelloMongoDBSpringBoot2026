package org.example.hellomongodbspringboot2026.repositories;

import org.example.hellomongodbspringboot2026.entities.UserDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDB,String> {

    Optional<UserDB> findUserDBByEmail(String username);
}
