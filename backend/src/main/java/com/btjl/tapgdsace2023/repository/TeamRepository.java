package com.btjl.tapgdsace2023.repository;

import com.btjl.tapgdsace2023.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "select * from teams where name = ?1", nativeQuery = true)
    Team getTeamByName(String name);

}
