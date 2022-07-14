package com.btjl.tapgdsace2023.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultPayload {

    private List<TeamRanking> group1Rankings;
    private List<TeamRanking> group2Rankings;

}