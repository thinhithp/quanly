package com.example.demo.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class TestQuerryService {

    @Autowired
    private TestQuerryRepository testQuerryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Modifying(clearAutomatically = true)
    public List<TestQuerry> getTestQueries() {
        return testQuerryRepository.getQuerry();
    }

}
