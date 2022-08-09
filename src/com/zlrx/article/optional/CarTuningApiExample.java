package com.zlrx.article.optional;


import com.zlrx.article.optional.domain.Car;

import java.util.Optional;
import java.util.Random;

public class CarTuningApiExample {

    private CarDbSimulator repository = new CarDbSimulator();

    public Optional<Car> tuning(Car car) {
        if (car != null) {
            Car tuningCar = updateEngine(car);
            return Optional.ofNullable(tuningCar);
        }
        return Optional.empty();
    }

    private Car updateEngine(Car car) {
        Car tunable = refreshFromDb(car);
        if (tunable != null) {
            //make some tuning
            tunable = tunable.updateHorsePower(300);
        }
        return tunable;
    }

    private Car refreshFromDb(Car car) {
        return repository.findCarById(car.id());
    }

    class CarDbSimulator {
        Car findCarById(long id) {
            Random random = new Random();
            if (random.nextBoolean()) {
                return new Car("Tesla", 1);
            }
            return null;
        }
    }

}
