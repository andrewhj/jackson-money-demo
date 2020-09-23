package com.example.money.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.zalando.jackson.datatype.money.MoneyModule;

@SpringBootApplication
public class JacksonMoneyDemoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(JacksonMoneyDemoApplication.class, args);
    }

    @Bean
    public MoneyModule moneyModule() {
        return new MoneyModule();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(final ObjectMapper objectMapper) {
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder,
                                     final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
        return restTemplateBuilder
            .additionalMessageConverters(mappingJackson2HttpMessageConverter)
            .build();
    }

}

