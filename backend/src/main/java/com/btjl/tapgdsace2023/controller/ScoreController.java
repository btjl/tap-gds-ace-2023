package com.btjl.tapgdsace2023.controller;

import com.btjl.tapgdsace2023.dto.FootballMatchScores;
import com.btjl.tapgdsace2023.service.TeamFootballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/scores/")
public class ScoreController {

    @Autowired
    TeamFootballMatchService teamFootballMatchService;

    @PostMapping
    public void createTeamFootballMatch(@RequestBody List<FootballMatchScores> footballMatchScoresList) {
        teamFootballMatchService.saveTeamFootballMatch(footballMatchScoresList);
    }

}
