package com.elastic.apm.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.apm.service.YesNoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/yesno")
@RestController
public class YesNoController {

    private final YesNoService yesNoService;
    
    @GetMapping
    public Mono<String> yesno() {
        return yesNoService.getYesNoAnswer();
    }
}
