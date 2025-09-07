package com.elastic.apm.facade;

import org.springframework.stereotype.Service;

import com.elastic.apm.service.StudentService;
import com.elastic.apm.service.YesNoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class AdminService {
    
    private final YesNoService yesNoService;
    private final StudentService studentService;

    public Mono<String> getYesNoAndStudent() {
        studentService.getStudents();
        return yesNoService.getYesNoAnswer();
    }
}
