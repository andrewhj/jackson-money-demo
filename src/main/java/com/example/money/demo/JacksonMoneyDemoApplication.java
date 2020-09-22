package com.example.money.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.zalando.jackson.datatype.money.MoneyModule;

@SpringBootApplication
public class JacksonMoneyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JacksonMoneyDemoApplication.class, args);
    }

    @Bean
    public MoneyModule moneyModule() {
        return new MoneyModule();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

