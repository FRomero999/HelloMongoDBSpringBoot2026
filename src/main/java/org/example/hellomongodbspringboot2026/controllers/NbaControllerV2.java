package org.example.hellomongodbspringboot2026.controllers;

import org.example.hellomongodbspringboot2026.repositories.NbaRepository;
import org.example.hellomongodbspringboot2026.entities.Team;
import org.example.hellomongodbspringboot2026.services.NbaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv2")
class NbaControllerV2 {

    private  final NbaService nbaService;

    public NbaControllerV2(NbaService nbaService){
        this.nbaService = nbaService;
    }

    @GetMapping("/teams")
    public List<Team> findAll() {
        return nbaService.findAll();
    }

    @GetMapping("/teams/{name}")
    public ResponseEntity<Team> findOne(@PathVariable String name){
        if(nbaService.findTeamByName(name).isPresent()){
            return ResponseEntity.ok(nbaService.findTeamByName(name).get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> save(@RequestBody Team team) {
        if(nbaService.save(team)!=null) {
            return ResponseEntity.ok(team);
        } else  {
            return ResponseEntity.badRequest().build();
        }
    }

}
