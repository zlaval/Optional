package com.zlrx.article.optional.domain;

import java.util.Random;

public record Car(
        long id,
        String producer,
        int year,
        int horsePower

) {

    private static final Random random = new Random();

    public Car(String producer, Integer year) {
        this(
                random.nextLong(),
                producer,
                year,
                100
        );
    }

    public Car updateHorsePower(int horsePower) {
        return new Car(
                this.id,
                this.producer,
                this.year,
                horsePower
        );
    }

}