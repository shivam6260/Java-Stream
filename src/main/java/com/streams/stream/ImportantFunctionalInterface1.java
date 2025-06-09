package com.streams.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class HelloOne implements Function<Integer,String> {

    @Override
    public String apply(Integer test) {
        return null;
    }
}

class HelloTwo implements Consumer<String> {

    @Override
    public void accept(String str) {
        System.out.println(str);
    }
}

class HelloThree implements Supplier<Integer> {

    @Override
    public Integer get() {
        return 5;
    }
}

public class ImportantFunctionalInterface1 {
    public static void main(String[] args) {
        // Works for you
        Function<Integer,Integer> doubleTheNumber = x -> 2 * x;
        Function<Integer,Integer> tripleTheNumber = x -> 3 * x;

        Function<Integer,Integer> objectFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 0;
            }
        };

        System.out.println(doubleTheNumber.apply(4));
        System.out.println(tripleTheNumber.apply(10));
        System.out.println(doubleTheNumber.andThen(tripleTheNumber).apply(10));


        // Consumer will take but not return anything
        Consumer<Integer> print = x -> {
            System.out.println(x);
        };
        print.accept(101);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        Consumer<List<Integer>> printList = x -> {
            for(int i : x) {
                System.out.print(i + " ");
            }
            System.out.println();
        };
        printList.accept(list);


        // Supplier - It will not take anything but return what we say
        Supplier<String> supplier = () -> "Hello from Supplier";
        System.out.println(supplier.get());



        // Combine Example -
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer,Integer> function = x -> x * x ;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> suppliers = () -> 1000;

        if(predicate.test(suppliers.get())) {
            consumer.accept(function.apply(suppliers.get()));
        }

        //BiPredicate

        BiPredicate<Integer , Integer> biPredicate = (x , y) -> (x + y) % 2 == 0;
        BiConsumer<Integer , Integer> biConsumer = (x, y) -> System.out.println(x + " " + y);
        BiFunction<String,String,Integer> biFunction = (x , y) -> (x + y).length();
        System.out.println(biFunction.apply("a","bcd"));

        // Method Invoking - use method without invoking & in place of Lambda Expression
        List<String> students = Arrays.asList("Ram" , "Shyam" , "Shivam");
        students.forEach(x -> System.out.print(x + "  "));
        students.forEach(System.out::print);


    }
}






















