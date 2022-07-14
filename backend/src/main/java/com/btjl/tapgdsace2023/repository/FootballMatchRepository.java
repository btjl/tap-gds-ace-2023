package com.btjl.tapgdsace2023.repository;

import com.btjl.tapgdsace2023.model.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch, Integer> {

}