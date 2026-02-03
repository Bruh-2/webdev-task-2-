package com.ehu.javacafe.repository;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Repository
public class InMemoryBeverageRepository implements BeverageRepository {

    private final List<Beverage> beverages = new ArrayList<>();

    public InMemoryBeverageRepository() {
        beverages.add(new Beverage(1L, "Espresso", 2.5, "Strong coffee"));
        beverages.add(new Beverage(2L, "Latte", 3.0, "Coffee with milk"));
        beverages.add(new Beverage(3L, "Cappuccino", 3.5, "Coffee with foam"));
    }

    @Override
    public List<Beverage> getAllBeverages() {
        return new ArrayList<>(beverages);
    }

    @Override
    public boolean addBeverage(Beverage beverage) {
        return beverages.add(beverage);
    }

    @Override
    public Beverage deleteBeverage(long id) {
        Iterator<Beverage> iterator = beverages.iterator();
        while (iterator.hasNext()) {
            Beverage b = iterator.next();
            if (b.getId() == id) {
                iterator.remove();
                return b;
            }
        }
        return null;
    }

    @Override
    public Beverage getBeverageById(long id) {
        return beverages.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public long getBeverageCount() {
        return beverages.size();
    }
}
