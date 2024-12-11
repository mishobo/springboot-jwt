package com.husseinabdallah.jwt_token.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class SubHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int subHeaderId;
    @Column(unique = true)
    @NotBlank(message = "Sub header name is required")
    private String subHeaderName;

    @ManyToOne
    @JoinColumn(name = "header_id")
    @JsonBackReference
    private Header header;
}
