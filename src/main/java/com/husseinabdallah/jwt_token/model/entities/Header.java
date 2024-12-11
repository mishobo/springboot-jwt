package com.husseinabdallah.jwt_token.model.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int headerId;

    @Column(unique = true)
    @NotBlank(message = "Header name is required")
    private String headerName;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "header")
    @JsonManagedReference
    private List<SubHeader> subHeader;
}
