package com.btjl.tapgdsace2023.service;

import com.btjl.tapgdsace2023.model.ResultPayload;
import com.btjl.tapgdsace2023.model.TeamFootballMatch;
import com.btjl.tapgdsace2023.model.TeamRanking;
import com.btjl.tapgdsace2023.repository.TeamFootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private List<TeamFootballMatch> getTeamsInGroup(List<TeamFootballMatch> teamFootballMatchList, int i) {
        return null;
    }
}
