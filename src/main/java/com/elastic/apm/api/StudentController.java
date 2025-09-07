package com.elastic.apm.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.apm.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Map<String, Object>> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/cached")
    public List<Map<String, Object>> getCachedStudents() {
        return studentService.getCachedStudents();
    }
}
