package com.zlrx.article.optional;


import com.zlrx.article.optional.domain.Car;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BadPracticeExample {

    private void methodWithOptionalInputMustCheckNullTwice(Optional<Car> carMaybePresent) {
        if (Objects.nonNull(carMaybePresent)) {
            if (carMaybePresent.isPresent()) {
                Car car = carMaybePresent.get();
                //Do some logic
            }
        }
    }

    public void valueMustWrapToCallMethodWithOptionalInput() {
        Car car = new Car("Tesla", 3);
        Optional<Car> carOptional = Optional.ofNullable(car);
        methodWithOptionalInputMustCheckNullTwice(carOptional);
    }

    public Optional<List<String>> collectionAsOptional() {
        Optional<List<String>> nullList = Optional.ofNullable(null);
        return nullList;
        //Never ever do this, or return null. Return with empty collection instead like List.of();
    }

}
