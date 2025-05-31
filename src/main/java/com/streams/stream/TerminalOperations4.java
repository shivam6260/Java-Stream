package com.streams.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        /// 1 Collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();
        System.out.println( list.stream().skip(1).collect(Collectors.toList()));

        /// 2 For Each
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 3 Reduce
        Optional<Integer> optionalInteger = list.stream().reduce( (x , y ) -> x + y);
        System.out.println(optionalInteger.get());

        /// 4 Count
        long res = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println(res);

        System.out.println(list.stream().map(x -> x + 2).collect(Collectors.toList()));

        /// 5 AnyMatch , allMatch , NoneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean c = list.stream().allMatch(x -> x > 0);
        System.out.println(c);

        boolean d = list.stream().noneMatch(x -> x < 0);
        System.out.println(d);

        /// 6 FindFirst , FindAny

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        /// 7 toArray()
        Object[] array = Stream.of(1 ,2 ,3 ,4).toArray();

        /// 8. min / max
        System.out.println("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o1 - o2));
        System.out.println("min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));

        // max/min is not the smallest and largest, it is the first and last element

        /// 9. forEachOrdered
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream:");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream:");
        numbers0.parallelStream().forEachOrdered(System.out::println);

//        Streams cannot be reused after a terminal operation has been called
//        Stream<String> stream = names.stream();
//        stream.forEach(System.out::println);
//        List<String> list1 = stream.map(String::toUpperCase).toList(); // exception

    }
}
