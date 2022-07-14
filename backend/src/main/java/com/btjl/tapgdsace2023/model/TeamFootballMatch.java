package com.btjl.tapgdsace2023.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "teams_footballmatches")
public class TeamFootballMatch {

    @EmbeddedId
    private TeamFootballMatchId id = new TeamFootballMatchId();

    @ManyToOne
    @MapsId("teamId")
    private Team team;


    @ManyToOne
    @MapsId("footballMatchId")
    private FootballMatch footballMatch;

    @Column
    private Integer score;

    public TeamFootballMatch() {
    }

    public TeamFootballMatch(TeamFootballMatchId id, Integer score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "TeamsFootballMatch{" +
                "id=" + id.toString() +
                ", winner=" + score +
                '}';
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setFootballMatch(FootballMatch footballMatch) {
        this.footballMatch = footballMatch;
    }

    @Embeddable
    @Getter
    @Setter
    public static class TeamFootballMatchId implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer teamId;
        private Integer footballMatchId;

        public TeamFootballMatchId() {
        }

        public TeamFootballMatchId(Integer teamId, Integer footballMatchId) {
            this.teamId = teamId;
            this.footballMatchId = footballMatchId;
        }

        @Override
        public String toString() {
            return "TeamFootballMatchId{" +
                    "teamId=" + teamId +
                    ", footballMatchId=" + footballMatchId +
                    '}';
        }
    }
}