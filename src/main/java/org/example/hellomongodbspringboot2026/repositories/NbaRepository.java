package org.example.hellomongodbspringboot2026.repositories;

import org.example.hellomongodbspringboot2026.entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  NbaRepository extends MongoRepository<Team,String> {

    public Optional<Team> getTeamByNombre(String name);
    public Optional<Team> getTeamByCiudad(String ciudad);
    public List<Team> findTeamsByConferencia(String conferencia);

}
