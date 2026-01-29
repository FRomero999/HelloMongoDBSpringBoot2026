package org.example.hellomongodbspringboot2026.services;

import org.example.hellomongodbspringboot2026.entities.Team;
import org.example.hellomongodbspringboot2026.exceptions.InvalidRequestException;
import org.example.hellomongodbspringboot2026.exceptions.TeamNotFoundException;
import org.example.hellomongodbspringboot2026.repositories.NbaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NbaService {

    private final NbaRepository nbaRepository;

    public NbaService(NbaRepository nbaRepository) {
        this.nbaRepository = nbaRepository;
    }

    public List<Team> findAll() {
        return nbaRepository.findAll();
    }

    public Optional<Team> findById(String id) {
        return nbaRepository.findById(id);
    }

    public Team save(Team team) {
        if(team==null) { throw new InvalidRequestException("Team is null"); }
        if(team.getNombre()==null) { throw new InvalidRequestException("Team name is null"); }
        if(team.getNombre().trim()=="") { throw new InvalidRequestException("Team name is empty"); }
        return nbaRepository.save(team);
    }

    public Team findTeamByName(String name) {
        return nbaRepository.getTeamByNombre(name).orElseThrow(()->new TeamNotFoundException("Team not found"));
    }
}
