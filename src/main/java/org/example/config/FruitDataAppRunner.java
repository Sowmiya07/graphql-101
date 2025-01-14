package org.example.config;

import org.example.repository.FruitRepository;
import org.example.repository.entity.Fruit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FruitDataAppRunner implements ApplicationRunner {

    private final FruitRepository fruitRepository;

    FruitDataAppRunner(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.fruitRepository.saveAll(
                Arrays.asList(
                    new Fruit("1", "Apple", "Red", "Rosa"),
                    new Fruit("2", "Banana", "Yellow", "Musa"),
                    new Fruit("3", "Lemon", "Yellow", "Citron")
                )
        );
        System.out.println("Fruits loaded");
    }
}
