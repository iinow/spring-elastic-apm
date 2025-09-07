package com.elastic.apm.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
    
    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getStudents() {
        return jdbcTemplate.queryForList("SELECT * FROM student");
    }

    @Cacheable("students")
    public List<Map<String, Object>> getCachedStudents() {
        return getStudents();
    }
}
