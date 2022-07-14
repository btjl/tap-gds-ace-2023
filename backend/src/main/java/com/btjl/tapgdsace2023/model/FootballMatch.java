package com.btjl.tapgdsace2023.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "footballmatches")
public class FootballMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}

