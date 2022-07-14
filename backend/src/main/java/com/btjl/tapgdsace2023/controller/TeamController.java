package com.btjl.tapgdsace2023.controller;

import com.btjl.tapgdsace2023.model.Team;
import com.btjl.tapgdsace2023.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/teams/")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @PostMapping
    public void createTeams(@RequestBody List<Team> teams) {
        teamRepository.saveAll(teams);
    }
}