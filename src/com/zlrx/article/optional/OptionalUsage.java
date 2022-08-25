package com.zlrx.article.optional;

import java.util.Optional;

public class OptionalUsage {

    private void start() {
        basicUsage();
        present();
        getAndSetOptionalValue();
        functions();
    }

    private void basicUsage() {
        String nullStr = null;
        Optional<String> stringOption = Optional.ofNullable(nullStr);
        String value = stringOption.orElse("Default value in case of null");
        System.out.println(value);
    }

    private void present() {
        String myString = "abcd";
        Optional<String> stringOption = Optional.ofNullable(myString);
        if (stringOption.isPresent()) {
            //do some calculations
            System.out.println(stringOption.get());
        }

        stringOption.ifPresent(System.out::println);

    }

    private void getAndSetOptionalValue() {
        String maybeNull = "hello";
        Optional<String> nullableOptional = Optional.ofNullable(maybeNull);

        String neverNull = "world";
        Optional<String> notNullableOptional = Optional.of(neverNull);

        Optional<String> emptyOptional = Optional.empty();

        String maybeNullpointerException = nullableOptional.get();
        String maybeDefaultValue = nullableOptional.orElse("olleh");
        String maybeSuppliedValue = nullableOptional.orElseGet(() -> "lleho");
        String exceptionIfValueNotPresent = nullableOptional.orElseThrow(() -> new IllegalArgumentException("Empty value is illegal here."));


    }

    class Mapper {
        Optional<Integer> calculateLength(String value) {
            return Optional.ofNullable(value)
                    .map(String::length);
        }
    }

    private void functions() {
        var name = Optional.of("Zalerix");

        Optional<String> nameOrEmpty = name.filter(val -> val.length() == 5);
        Optional<Integer> nameLength = name.map(String::length);


        var mapper = new Mapper();
        Optional<Integer> emptyOrLength = name.flatMap(v -> mapper.calculateLength(v));

        Optional<Integer> sumOfChars = name
                .filter(val -> val.length() > 5)
                .map(s -> s + s)
                .flatMap(mapper::calculateLength);

        //  name.ifPresentOrElse();
        //sum

        System.out.println(sumOfChars);
    }

    //todo null check chain example

    public static void main(String[] args) {
        OptionalUsage optionalUsage = new OptionalUsage();
        optionalUsage.start();
    }

}
