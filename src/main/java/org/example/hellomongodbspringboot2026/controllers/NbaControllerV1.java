package org.example.hellomongodbspringboot2026.controllers;

import org.example.hellomongodbspringboot2026.repositories.NbaRepository;
import org.example.hellomongodbspringboot2026.entities.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/apiv1")
class NbaControllerV1 {

    NbaRepository nbaRepository;

    NbaControllerV1(NbaRepository nbaRepository) {
        this.nbaRepository = nbaRepository;
    }

    @GetMapping("/teams")
    public List<Team> findAll() {
        return nbaRepository.findAll();
    }

}
