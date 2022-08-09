package com.zlrx.article.optional;


import com.zlrx.article.optional.domain.Car;

public class NullPointerExceptionExample {

    public static void main(String[] args) {
        Car car = null;
        car.year();
    }

}
