package com.ehu.javacafe;

import com.ehu.javacafe.service.CoffeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotation {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.ehu.javacafe");

        CoffeeService coffeeService = ctx.getBean(CoffeeService.class);
        coffeeService.getAllBeverages();

        ctx.close();
    }
}
