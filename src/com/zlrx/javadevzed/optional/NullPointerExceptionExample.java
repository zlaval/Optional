package com.zlrx.javadevzed.optional;


import com.zlrx.javadevzed.optional.domain.Car;

public class NullPointerExceptionExample {

    public static void main(String[] args) {
        Car car = null;
        car.year();
    }

}
