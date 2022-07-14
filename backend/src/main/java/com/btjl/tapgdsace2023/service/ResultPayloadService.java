package com.btjl.tapgdsace2023.service;

import com.btjl.tapgdsace2023.model.ResultPayload;
import com.btjl.tapgdsace2023.model.TeamFootballMatch;
import com.btjl.tapgdsace2023.model.TeamRanking;
import com.btjl.tapgdsace2023.repository.TeamFootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultPayloadService {

    @Autowired
    TeamFootballMatchRepository teamFootballMatchRepository;

    public ResultPayload getGroupRankings() {

        List<TeamRanking> group1Rankings, group2Rankings;

        List<TeamFootballMatch> teamFootballMatchList = teamFootballMatchRepository.findAll();

        List<TeamFootballMatch> group1 = getTeamsInGroup(teamFootballMatchList, 1);
        List<TeamFootballMatch> group2 = getTeamsInGroup(teamFootballMatchList, 2);

        group1Rankings = calculateGroupRankingsForTeamsInGroup(group1);
        group2Rankings = calculateGroupRankingsForTeamsInGroup(group2);

        return new ResultPayload(group1Rankings, group2Rankings);
    }

    private List<TeamRanking> calculateGroupRankingsForTeamsInGroup(List<TeamFootballMatch> group1) {
        return null;
    }

    private Integer convertRegistrationDateToValueInDays(String registrationDate) {
        String[] ddMMSplit = registrationDate.split("/");
        int dd = Integer.parseInt(ddMMSplit[0]);
        int MM = Integer.parseInt(ddMMSplit[1]) * 30;
        return dd + MM;
    }

    private List<TeamFootballMatch> getTeamsInGroup(List<TeamFootballMatch> teamFootballMatchList, int groupNumber) {

        List<TeamFootballMatch> result = new ArrayList<>();
        for (TeamFootballMatch teamFootballMatch : teamFootballMatchList) {
            if (teamFootballMatch.getTeam().getGroupNumber().equals(groupNumber)) {
                result.add(teamFootballMatch);
            }
        }
        return result;
    }
}
