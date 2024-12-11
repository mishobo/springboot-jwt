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
    private Integer headerId;

    @Column(unique = true)
    @NotBlank(message = "Header name is required")
    private String headerName;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<SubHeader> subHeader;
}
