package com.zlrx.article.optional;


import com.zlrx.article.optional.domain.Car;

import java.util.Optional;
import java.util.Random;

public class CarTuningApiExample {

    private CarDbSimulator repository = new CarDbSimulator();

    public Optional<Car> tuning(Car car) {
        return Optional.ofNullable(car)
                .map(this::updateEngine);
    }

    private Car updateEngine(Car car) {
        Car tunable = refreshFromDb(car);
        if (tunable != null) {
            tunable = tunable.updateHorsePower(300);
        }
        return tunable;
    }

    private Car refreshFromDb(Car car) {
        return repository.findCarById(car.id());
    }

    class CarDbSimulator {

        //Randomly returns a Car instance or null
        Car findCarById(long id) {
            Random random = new Random();
            if (random.nextBoolean()) {
                return new Car("Toyota", 1);
            }
            return null;
        }
    }

}
