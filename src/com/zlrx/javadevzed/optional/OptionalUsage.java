package com.zlrx.javadevzed.optional;

import java.util.Optional;

public class OptionalUsage {



  public static void main(String[] args) {
    String something = null;
    Optional<String> string = Optional.ofNullable(something);
    String value = string.orElse("see this if something's value is null");
    System.out.println(value);

    if (string.isPresent()) {
      //do some callculation
    }
  }


}
