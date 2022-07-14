package com.btjl.tapgdsace2023.repository;

import com.btjl.tapgdsace2023.model.TeamFootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamFootballMatchRepository extends JpaRepository<TeamFootballMatch, TeamFootballMatch.TeamFootballMatchId> {
}

