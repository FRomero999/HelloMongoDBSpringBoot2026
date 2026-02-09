package org.example.hellomongodbspringboot2026.repositories;

import org.example.hellomongodbspringboot2026.entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  NbaRepository extends MongoRepository<Team,String> {
}
