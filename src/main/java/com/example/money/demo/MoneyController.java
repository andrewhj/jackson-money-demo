package com.example.money.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

@RestController("money")
class MoneyController {
    private final ObjectMapper objectMapper;

    public MoneyController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public MonetaryAmount example() {
        final CurrencyUnit usd = Monetary.getCurrency("USD");
        final MonetaryAmount money = Monetary.getDefaultAmountFactory().setCurrency(usd).setNumber(200).create();
        return money;
    }
}
