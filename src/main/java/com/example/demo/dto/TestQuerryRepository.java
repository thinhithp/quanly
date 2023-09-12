package com.example.demo.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestQuerryRepository extends JpaRepository<TestQuerry, Long> {
            @Query(value = "CALL public.test_querry(null)", nativeQuery = true)
            List<TestQuerry> getQuerry();

}
