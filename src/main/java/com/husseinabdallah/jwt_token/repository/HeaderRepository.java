package com.husseinabdallah.jwt_token.repository;

import com.husseinabdallah.jwt_token.model.entities.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Integer> {

    Header findByHeaderId(Integer headerId);
}
