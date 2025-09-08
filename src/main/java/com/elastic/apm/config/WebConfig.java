package com.elastic.apm.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class WebConfig {

    private Logger log = Logger.getLogger(WebConfig.class.getName());

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .filter(logRequest())
                .filter(logResponseBody())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            StringBuilder sb = new StringBuilder();
            sb.append("\n==========[WebClient Request]==========\n");
            sb.append("URI      : ").append(request.url()).append("\n");
            sb.append("Method   : ").append(request.method()).append("\n");
            sb.append("Headers  : ").append(request.headers()).append("\n");
            sb.append("=======================================\n");
            log.log(Level.INFO, sb.toString());
            return Mono.just(request);
        });
    }

    private ExchangeFilterFunction logResponseBody() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            return response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(body -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n==========[WebClient Response]=========");
                    sb.append("\nStatus   : ").append(response.statusCode());
                    sb.append("\nBody     : ").append(body);
                    sb.append("\n=======================================\n");
                    log.log(Level.INFO, sb.toString());
                    // bodyToMono 사용 시 body는 소모되므로, mutate().body(body)로 복구
                    return Mono.just(response.mutate().body(body).build());
                });
        });
    }

}
