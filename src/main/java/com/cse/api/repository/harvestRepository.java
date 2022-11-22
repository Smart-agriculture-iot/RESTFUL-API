package com.cse.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cse.api.model.harvest;

@Repository
public interface harvestRepository extends JpaRepository<harvest, Long> {
	harvest findById(String id);

    harvest findTopByOrderByIdDesc();

    @Query("SELECT h FROM harvest h WHERE h.year=?1")
    List<harvest> findclientByYear(String year);
}

