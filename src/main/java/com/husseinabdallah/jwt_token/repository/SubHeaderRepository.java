package com.husseinabdallah.jwt_token.repository;

import com.husseinabdallah.jwt_token.model.entities.SubHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubHeaderRepository extends JpaRepository <SubHeader, Integer> {

    SubHeader findBySubHeaderId(Integer subHeaderId);

}
