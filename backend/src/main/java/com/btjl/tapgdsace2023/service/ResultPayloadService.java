package com.btjl.tapgdsace2023.service;

import com.btjl.tapgdsace2023.model.ResultPayload;
import com.btjl.tapgdsace2023.model.TeamFootballMatch;
import com.btjl.tapgdsace2023.model.TeamRanking;
import com.btjl.tapgdsace2023.repository.TeamFootballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    private List<TeamRanking> calculateGroupRankingsForTeamsInGroup(List<TeamFootballMatch> group) {

        Map<Integer, TeamRanking> teamToRankingsMap = createTeamToRankingMap(group);
        Set<TeamFootballMatch> visited = new HashSet<>();

        TeamFootballMatch cur;
        for (int i = 0; i < group.size(); i++) {
            cur = group.get(i);
            Integer curTeamId = cur.getTeam().getId();
            Integer curTeamScore = cur.getScore();

            if (visited.contains(cur)) {
                continue;
            }
            visited.add(cur);
            Integer matchId = cur.getFootballMatch().getId();

            TeamFootballMatch complement = null;
            for (int j = i + 1; j < group.size(); j++) {
                complement = group.get(j);

                TeamRanking curTeamRanking;
                TeamRanking complementTeamRanking;
                if (complement.getFootballMatch().getId().equals(matchId)) {
                    visited.add(complement);

                    Integer complementTeamId = complement.getTeam().getId();
                    Integer complementTeamScore = complement.getScore();

                    curTeamRanking = teamToRankingsMap.get(curTeamId);
                    complementTeamRanking = teamToRankingsMap.get(complementTeamId);

                    curTeamRanking.setTotalGoals(curTeamRanking.getTotalGoals() + curTeamScore);
                    complementTeamRanking.setTotalGoals(complementTeamRanking.getTotalGoals() + complementTeamScore);


                    if (curTeamScore > complementTeamScore) { // CUR WINS
                        curTeamRanking.setTotalMatchPoint(curTeamRanking.getTotalMatchPoint() + 3);
                        curTeamRanking.setTotalAlternateMatchPoint(curTeamRanking.getTotalAlternateMatchPoint() + 5);

                        complementTeamRanking.setTotalAlternateMatchPoint(complementTeamRanking.getTotalAlternateMatchPoint() + 1);

                    } else if (curTeamScore < complementTeamScore) { // COMPLEMENT WINS
                        complementTeamRanking.setTotalMatchPoint(complementTeamRanking.getTotalMatchPoint() + 3);
                        complementTeamRanking.setTotalAlternateMatchPoint(complementTeamRanking.getTotalAlternateMatchPoint() + 5);

                        curTeamRanking.setTotalAlternateMatchPoint(curTeamRanking.getTotalAlternateMatchPoint() + 1);

                    } else { // DRAW
                        curTeamRanking.setTotalMatchPoint(curTeamRanking.getTotalMatchPoint() + 1);
                        curTeamRanking.setTotalAlternateMatchPoint(curTeamRanking.getTotalAlternateMatchPoint() + 3);

                        complementTeamRanking.setTotalMatchPoint(complementTeamRanking.getTotalMatchPoint() + 1);
                        complementTeamRanking.setTotalAlternateMatchPoint(complementTeamRanking.getTotalAlternateMatchPoint() + 3);

                    }
                }
            }
        }

        List<TeamRanking> result = new ArrayList<>();
        for (Integer teamId : teamToRankingsMap.keySet()) {
            result.add(teamToRankingsMap.get(teamId));
        }

        result.sort(Collections.reverseOrder());

        return result;
    }

    private Map<Integer, TeamRanking> createTeamToRankingMap(List<TeamFootballMatch> group) {
        Map<Integer, TeamRanking> result = new HashMap<>();

        for (TeamFootballMatch teamFootballMatch : group) {
            if (!result.containsKey(teamFootballMatch.getTeam().getId())) {

                TeamRanking teamRanking = new TeamRanking(teamFootballMatch.getTeam().getName(), 0, 0, 0, 0);
                teamRanking.setRegistrationDateInDays(
                        convertRegistrationDateToValueInDays(
                                teamFootballMatch.getTeam().getRegistrationDate()));

                result.put(teamFootballMatch.getTeam().getId(), teamRanking);
            }
        }
        return result;
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
