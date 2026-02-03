package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BeverageSelector {

    private final CoffeeService coffeeService;

    public BeverageSelector(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public List<Beverage> selectBeverage() {
        List<Beverage> all = coffeeService.getAllBeverages();
        List<Beverage> result = new ArrayList<>();
        if (!all.isEmpty()) {
            result.add(all.get(new Random().nextInt(all.size())));
        }
        return result;
    }
}
