package com.husseinabdallah.jwt_token.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class SubHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotBlank(message = "Sub header name is required")
    private String subHeaderName;
    @ManyToOne
    @JoinColumn(name = "header_id")
    private Header header;
}
