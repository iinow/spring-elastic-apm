package com.elastic.apm.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.apm.facade.AdminService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class MasterController {

    private final AdminService masterService;
    
    @GetMapping("/master")
    public Mono<String> master() {
        return masterService.getYesNoAndStudent();
    }
}
