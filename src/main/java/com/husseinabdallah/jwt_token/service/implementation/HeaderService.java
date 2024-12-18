package com.husseinabdallah.jwt_token.service.implementation;

import com.husseinabdallah.jwt_token.model.dtos.ApiResponse;
import com.husseinabdallah.jwt_token.model.dtos.NavBarDto;
import com.husseinabdallah.jwt_token.model.entities.Header;
import com.husseinabdallah.jwt_token.model.entities.SubHeader;
import com.husseinabdallah.jwt_token.repository.HeaderRepository;
import com.husseinabdallah.jwt_token.repository.SubHeaderRepository;
import com.husseinabdallah.jwt_token.service.interfaces.HeaderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HeaderService implements HeaderInterface {

    private final HeaderRepository headerRepository;
    private final SubHeaderRepository subHeaderRepository;

    public HeaderService(HeaderRepository headerRepository, SubHeaderRepository subHeaderRepository) {

        this.headerRepository = headerRepository;
        this.subHeaderRepository = subHeaderRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<Header>> createHeader(NavBarDto navBar) {
        var savedHeader = headerRepository.save(
                new Header(navBar.headerName())
        );

        for (int i = 0; navBar.subHeader().size() > i; i++) {
           var savedSubHeaders = subHeaderRepository.save(
                    new SubHeader(
                            navBar.subHeader().get(i).subHeaderName(),
                            savedHeader
                    )
            );

           System.out.println(savedSubHeaders);
        }

        ApiResponse<Header> response = new ApiResponse<>(
                true,
                "Menu Header saved successfully",
                savedHeader,
                null
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<Header>> getHeader(int headerId) {
        var header = headerRepository.findByHeaderId(headerId);

            ApiResponse<Header> response = new ApiResponse<>(
                    true,
                    "Menu Header fetched successfully",
                    header,
                    null
            );

        return ResponseEntity.ok(response);
    }
}
