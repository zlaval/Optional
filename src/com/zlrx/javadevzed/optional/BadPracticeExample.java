package com.zlrx.javadevzed.optional;

import com.zlrx.javadevzed.optional.pojo.Car;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BadPracticeExample {

  private void methodWithOptionalParam(Optional<Car> carMaybePresent) {
    if (Objects.nonNull(carMaybePresent)) {
      if (carMaybePresent.isPresent()) {
        Car car = carMaybePresent.get();
        //Do some logic
      }
    }
  }

  public void valueMustWrapToCallMethodWithOptionalParam() {
    Car car = new Car();
    Optional<Car> carOptional = Optional.ofNullable(car);
    methodWithOptionalParam(carOptional);
  }


  public Optional<List<String>> collectionAsOptional() {
    List<String> strings = null;
    Optional<List<String>> nullList = Optional.ofNullable(strings);
    return nullList;
    //Never ever do this, or return null. Return with empty collection instead.
  }


  public static void main(String[] args) {

  }



}
