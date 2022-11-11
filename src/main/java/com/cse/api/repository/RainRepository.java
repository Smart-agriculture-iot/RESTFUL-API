package com.cse.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cse.api.model.Rain;

@Repository
public interface RainRepository extends JpaRepository<Rain, Long> {
	Rain findById(String id);

    Rain findTopByOrderByIdDesc();

    @Query("SELECT r FROM Rain r WHERE r.year=?1")
    List<Rain> findclientByYear(String year);
}