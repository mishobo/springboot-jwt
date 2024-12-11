package com.husseinabdallah.jwt_token.controller;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.SubHeader;
import com.husseinabdallah.jwt_token.service.interfaces.SubHeaderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sub-headers")
public class SubHeaderController {

    private final SubHeaderInterface subHeaderInterface;

    public SubHeaderController(SubHeaderInterface subHeaderInterface) {
        this.subHeaderInterface = subHeaderInterface;
    }

    @PostMapping(value = "/create-sub-header", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponse<SubHeader>> createSubHeader(@RequestBody SubHeader subHeader){
        System.out.println(subHeader);
        return subHeaderInterface.createSubHeader(subHeader);
    }


}
