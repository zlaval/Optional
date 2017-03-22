package com.zlrx.javadevzed.optional.pojo;

import java.util.Random;

public class Car {

  private static final Random random = new Random();

  private final long id = random.nextLong();

  private final String manufacturer;

  private final Integer age;

  private int horsePower = 100;


  public Car(String manufacturer, Integer age) {
    this.manufacturer = manufacturer;
    this.age = age;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Integer getAge() {
    return age;
  }

  public long getId() {
    return id;
  }

  public int getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(int horsePower) {
    this.horsePower = horsePower;
  }
}
