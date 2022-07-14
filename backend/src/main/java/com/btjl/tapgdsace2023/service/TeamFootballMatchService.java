package com.btjl.tapgdsace2023.service;

import com.btjl.tapgdsace2023.dto.FootballMatchScores;
import com.btjl.tapgdsace2023.model.FootballMatch;
import com.btjl.tapgdsace2023.model.Team;
import com.btjl.tapgdsace2023.model.TeamFootballMatch;
import com.btjl.tapgdsace2023.repository.FootballMatchRepository;
import com.btjl.tapgdsace2023.repository.TeamFootballMatchRepository;
import com.btjl.tapgdsace2023.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFootballMatchService {

    final
    FootballMatchRepository footballMatchRepository;

    final
    TeamRepository teamRepository;

    final
    TeamFootballMatchRepository teamFootballMatchRepository;

    public TeamFootballMatchService(FootballMatchRepository footballMatchRepository, TeamRepository teamRepository, TeamFootballMatchRepository teamFootballMatchRepository) {
        this.footballMatchRepository = footballMatchRepository;
        this.teamRepository = teamRepository;
        this.teamFootballMatchRepository = teamFootballMatchRepository;
    }

    public void saveTeamFootballMatch(List<FootballMatchScores> footballMatchScoresList) {

        Team team1 = null;
        Team team2 = null;
        FootballMatch footballMatch = null;

        for (FootballMatchScores footballMatchScores : footballMatchScoresList) {

            team1 = teamRepository.getTeamByName(footballMatchScores.getTeam1Name());
            team2 = teamRepository.getTeamByName(footballMatchScores.getTeam2Name());

            footballMatch = new FootballMatch();

            footballMatchRepository.save(footballMatch);

            TeamFootballMatch.TeamFootballMatchId teamFootballMatchId1 = new TeamFootballMatch.TeamFootballMatchId(team1.getId(), footballMatch.getId());
            TeamFootballMatch teamFootballMatch1 = new TeamFootballMatch(teamFootballMatchId1, footballMatchScores.getTeam1Score());
            teamFootballMatch1.setTeam(team1);
            teamFootballMatch1.setFootballMatch(footballMatch);

            TeamFootballMatch.TeamFootballMatchId teamFootballMatchId2 = new TeamFootballMatch.TeamFootballMatchId(team2.getId(), footballMatch.getId());
            TeamFootballMatch teamFootballMatch2 = new TeamFootballMatch(teamFootballMatchId2, footballMatchScores.getTeam2Score());
            teamFootballMatch2.setTeam(team2);
            teamFootballMatch2.setFootballMatch(footballMatch);

            teamFootballMatchRepository.save(teamFootballMatch1);
            teamFootballMatchRepository.save(teamFootballMatch2);
        }
    }
}