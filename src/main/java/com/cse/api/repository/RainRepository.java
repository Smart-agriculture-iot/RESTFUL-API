package com.cse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.api.model.Rain;

@Repository
public interface RainRepository extends JpaRepository<Rain, Long> {
	Rain findById(String id);

    Rain findTopByOrderByIdDesc();
}