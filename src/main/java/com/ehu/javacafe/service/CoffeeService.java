package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.repository.BeverageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final BeverageRepository beverageRepository;

    public CoffeeService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<Beverage> getAllBeverages() {
        return beverageRepository.getAllBeverages();
    }

    public Beverage getBeverageById(long id) {
        return beverageRepository.getAllBeverages().stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public long getBeverageCount() {
        return beverageRepository.getBeverageCount();
    }
}
