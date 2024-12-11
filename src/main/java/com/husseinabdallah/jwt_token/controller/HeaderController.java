package com.husseinabdallah.jwt_token.controller;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.entities.Header;
import com.husseinabdallah.jwt_token.service.interfaces.HeaderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/headers")
public class HeaderController {

    private final HeaderInterface headerInterface;

    public HeaderController(HeaderInterface headerInterface) {
        this.headerInterface = headerInterface;
    }

    @PostMapping(value = "/create-header", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponse<Header>> createHeader(@RequestBody Header header) {
        return headerInterface.createHeader(header);
    }

}
