package com.btjl.tapgdsace2023.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamRanking implements Comparable<TeamRanking> {

    private String teamName;
    private Integer totalMatchPoint;
    private Integer totalGoals;
    private Integer totalAlternateMatchPoint;
    private Integer registrationDateInDays;


    public TeamRanking() {
    }

    public TeamRanking(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int compareTo(TeamRanking o) {
        int compare = totalMatchPoint.compareTo(o.getTotalMatchPoint());
        if (compare == 0) {
            compare = totalGoals.compareTo(o.getTotalGoals());
            if (compare == 0) {
                compare = totalAlternateMatchPoint.compareTo(o.getTotalAlternateMatchPoint());
                if (compare == 0) {
                    // reverse the sort
                    Integer r_registrationDateInDays = -1 * registrationDateInDays;
                    Integer r_other_registrationDateInDays = -1 * o.getRegistrationDateInDays();

                    compare = r_registrationDateInDays.compareTo(r_other_registrationDateInDays);
                }
            }
        }
        return compare;
    }
}