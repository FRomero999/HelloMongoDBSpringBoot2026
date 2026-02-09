package org.example.hellomongodbspringboot2026.repositories;

import org.example.hellomongodbspringboot2026.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends MongoRepository<User,String> {

    /* Esta será la forma en la que springboot buscará los usuarios en la bbdd */
    Optional<User> findUserByEmail(String email);
}
