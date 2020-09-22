package com.example.money.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javamoney.moneta.Money;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.money.MonetaryAmount;

@RestController
@RequestMapping("client")
class MoneyClientController {
    final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public MoneyClientController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public MonetaryAmount remote() {
        final ResponseEntity<Money> exchange = restTemplate.exchange("http://localhost:8080", HttpMethod.GET, null, Money.class);
        final Money body = exchange.getBody();
        return body;
    }
}
