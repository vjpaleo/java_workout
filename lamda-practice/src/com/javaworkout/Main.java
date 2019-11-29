package com.javaworkout;

import com.javaworkout.function.Consumer;
import com.javaworkout.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // method chaining
        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        Consumer<String> c3 = s-> {
            c1.accept(s);
            c2.accept(s);
        };

        Consumer<String> c4 = c1.andThen(null);

        c3.accept("Hello C3");
        c4.accept("Hello C4");


        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();
    }
}
