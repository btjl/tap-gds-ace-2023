package com.btjl.tapgdsace2023.controller;

import com.btjl.tapgdsace2023.repository.FootballMatchRepository;
import com.btjl.tapgdsace2023.repository.TeamFootballMatchRepository;
import com.btjl.tapgdsace2023.repository.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/composite/")
public class CompositeController {

    private final TeamRepository teamRepository;
    private final FootballMatchRepository footballMatchRepository;
    private final TeamFootballMatchRepository teamFootballMatchRepository;

    public CompositeController(TeamRepository teamRepository, FootballMatchRepository footballMatchRepository, TeamFootballMatchRepository teamFootballMatchRepository) {
        this.teamRepository = teamRepository;
        this.footballMatchRepository = footballMatchRepository;
        this.teamFootballMatchRepository = teamFootballMatchRepository;
    }
}
