package com.zlrx.javadevzed.optional;

import java.util.Objects;
import java.util.Optional;

public class OptionalUsage {

  private void start() {
    basicUsage();
    present();
  }

  private void basicUsage() {
    String something = null;
    Optional<String> string = Optional.ofNullable(something);
    String value = string.orElse("see this if something's value is null");
    System.out.println(value);
  }

  private void present() {
    String myString = "abcd";
    Optional<String> string = Optional.ofNullable(myString);
    if (string.isPresent()) {
      //do some callculation
      System.out.println(string.get());
    }

    string.ifPresent(System.out::println);

  }

  private void getAndSetOptionalValue() {
    String maybeNull = "hello";
    Optional<String> nullableOptional = Optional.ofNullable(maybeNull);

    String neverNull = "world";
    Optional.of(neverNull);

    Optional.empty();

    nullableOptional.get();
    nullableOptional.orElse("olleh");
    nullableOptional.orElseGet(() -> "lleho");
    nullableOptional.orElseThrow(() -> new IllegalArgumentException("Empty value is illegal here."));
  }

  private void functions() {
    Optional<String> name = Optional.of("Zalan");

    name.filter(val -> val.length() == 5);
    name.map(String::length);
    name.flatMap(str -> Objects.isNull(str) ? Optional.empty() : Optional.of(str.length()));

    name.filter(val -> val
      .length() == 5)
      .map(String::length)
      .flatMap(num -> num < 1 ? Optional.empty() : Optional.of(num));
  }

  public static void main(String[] args) {
    OptionalUsage optionalUsage = new OptionalUsage();
    optionalUsage.start();
  }

}
