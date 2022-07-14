package com.btjl.tapgdsace2023.controller;

import com.btjl.tapgdsace2023.model.ResultPayload;
import com.btjl.tapgdsace2023.service.ResultPayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/results/")
public class ResultController {

    @Autowired
    ResultPayloadService resultPayloadService;

    @GetMapping
    public ResultPayload getTeamRankings() {
        return resultPayloadService.getGroupRankings();
    }

}
