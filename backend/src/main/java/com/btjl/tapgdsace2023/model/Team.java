package com.btjl.tapgdsace2023.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @JsonProperty("name")
    @Column(unique = true, nullable = false)
    private String name;

    //    @JsonProperty("registrationDate")
    @JsonFormat(pattern = "MM-dd", shape = JsonFormat.Shape.STRING)
    private String registrationDate;

    //    @JsonProperty("groupNumber")
    private Integer groupNumber;

    public Team() {
    }

    public Team(String name, String registrationDate, Integer groupNumber) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, %s, %s\n", id, name, registrationDate, groupNumber);
    }
}
