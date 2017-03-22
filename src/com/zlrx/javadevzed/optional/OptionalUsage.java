package com.zlrx.javadevzed.optional;

import java.util.Objects;
import java.util.Optional;

public class OptionalUsage {

    private void start() {
        basicUsage();
        present();
        getAndSetOptionalValue();
        functions();
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
        Optional<String> notNullableOptional = Optional.of(neverNull);

        Optional<String> emptyOptional = Optional.empty();

        String maybeNullpointerException = nullableOptional.get();
        String maybeDefaultValue = nullableOptional.orElse("olleh");
        String maybeSupliedValue = nullableOptional.orElseGet(() -> "lleho");
        String exceptionIfValueNotPresent = nullableOptional.orElseThrow(() -> new IllegalArgumentException("Empty value is illegal here."));
    }

    private void functions() {
        Optional<String> name = Optional.of("Zalan");

        Optional<String> nameOrEmpty = name.filter(val -> val.length() == 5);
        Optional<Integer> nameLength = name.map(String::length);
        Optional<Integer> emptyOrLength = name.flatMap(str -> Objects.isNull(str) ? nameLength : Optional.of(str.length()));

        Optional<Integer> sumOfChars = name.filter(val -> val
                .length() == 5)
                .map(String::length)
                .flatMap(num -> num < 1 ? Optional.empty() : Optional.of(num));
        System.out.println(sumOfChars);
    }

    public static void main(String[] args) {
        OptionalUsage optionalUsage = new OptionalUsage();
        optionalUsage.start();
    }

}
