package com.example.money.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

@RestController("money")
class MoneyController {
    @GetMapping
    public MonetaryAmount example() {
        final CurrencyUnit usd = Monetary.getCurrency("USD");
        final MonetaryAmount money = Monetary.getDefaultAmountFactory().setCurrency(usd).setNumber(200).create();
        return money;
    }
}
