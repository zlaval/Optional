package com.zlrx.javadevzed.optional.pojo;

public class Car {

  private String manufacturer;

  private Integer age;

  public Car() {
  }

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

}
