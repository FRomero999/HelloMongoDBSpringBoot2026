package org.example.hellomongodbspringboot2026.services;

import org.example.hellomongodbspringboot2026.entities.Team;
import org.example.hellomongodbspringboot2026.repositories.NbaRepository;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NbaService {

    private final NbaRepository nbaRepository;
    private final LLMService llmService;

    public NbaService(NbaRepository nbaRepository, LLMService llmService) {
        this.llmService = llmService;
        this.nbaRepository = nbaRepository;
    }

    public List<Team> findAll() {
        return nbaRepository.findAll();
    }

    public Optional<Team> findById(String id) {
        return nbaRepository.findById(id);
    }

    public Team save(Team team) {
        return nbaRepository.save(team);
    }

    public Team findTeamByName(String name) {
        Team team = nbaRepository.findTeamByNombre(name);
        team.setHistory(llmService.generateHistory(team.getNombre()));
        return team;
    }

    public String generateHistoryTeam(String name){
        Team team = nbaRepository.findTeamByNombre(name);
        if(team != null){
             return llmService.generateHistory(name);
        } else{
            return "Ese equipo no existe";
        }
    }


}
