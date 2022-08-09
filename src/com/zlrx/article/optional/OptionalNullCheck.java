package com.zlrx.article.optional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalNullCheck {

    static class Piston {

    }

    static class EngineBlock {
        List<Piston> pistons;

        public EngineBlock(List<Piston> pistons) {
            this.pistons = pistons;
        }
    }

    static class Engine {
        EngineBlock block;

        public Engine(EngineBlock block) {
            this.block = block;
        }
    }

    static class Car {
        Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }
    }

    public static void main(String[] args) {

        Car toyota = new Car(
                new Engine(
                        new EngineBlock(
                                List.of(new Piston(), new Piston())
                        )
                )
        );

        Car ford = new Car(
                new Engine(null)
        );


        List<Piston> pistons = List.of();//create unnecess list
        if (ford != null && ford.engine != null && ford.engine.block != null && ford.engine.block.pistons != null) {
            pistons = ford.engine.block.pistons;
        }


        //or
        List<Piston> pistonsFromNull = null;
        if (ford != null && ford.engine != null && ford.engine.block != null) {
            if (ford.engine.block.pistons != null) {
                pistons = ford.engine.block.pistons;
            } else {
                pistons = List.of();
            }

        }

        //or
        List<Piston> pistonsDeep = List.of();
        if (Objects.nonNull(ford)) {
            var engine = ford.engine;
            if (Objects.nonNull(engine)) {
                var block = engine.block;
                if (Objects.nonNull(block)) {
                    var p = block.pistons;
                    if (Objects.nonNull(p)) {
                        pistonsDeep = engine.block.pistons;
                    }
                }
            }
        }


        var pistonsFromOptional = Optional.ofNullable(toyota)
                .map(it -> it.engine)
                .map(it -> it.block)
                .map(it -> it.pistons)
                .orElse(List.of());


    }


}
