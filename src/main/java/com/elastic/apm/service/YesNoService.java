package com.elastic.apm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class YesNoService {
    
    private WebClient webClient = WebClient.create();

    public Mono<String> getYesNoAnswer() {
        return webClient.get()
                .uri("https://yesno.wtf/api")
                .retrieve()
                .bodyToMono(String.class);
    }
}
