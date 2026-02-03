package com.ehu.javacafe.controller;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.service.BeverageSelector;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeverageController {

    private final BeverageSelector beverageSelector;
    private final ObjectMapper objectMapper;

    public BeverageController(BeverageSelector beverageSelector) {
        this.beverageSelector = beverageSelector;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("/beverages")
    public List<Beverage> getBeverages() {
        return beverageSelector.selectBeverage();
    }

    @GetMapping("/beverages/string")
    public String getBeveragesAsString() throws Exception {
        return objectMapper.writeValueAsString(beverageSelector.selectBeverage());
    }
}
