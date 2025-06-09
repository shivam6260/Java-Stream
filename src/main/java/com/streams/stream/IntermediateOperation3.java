package com.streams.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperation3 {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream.
        // They are lazy, meaning they don't execute until a terminal operation is invoked.

        /// 1 Filter
        List<String> list = Arrays.asList("Akshit" , "Ram" , "Shyam" , "Ghyansham", "Akash" , "Akshit");
        Stream<String> streamFiltered =  list.stream().filter(x -> x.toLowerCase().startsWith("a"));

        Stream<String> result = list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String x) {
                return x.toLowerCase().startsWith("a");
            }
        });

        //No Filtering at this point
        System.out.println(list);
        result.forEach( x -> System.out.println(x));
        long res = list.stream().filter(x -> x.toLowerCase().startsWith("a")).count();
        System.out.println(res);

        /// 2 Map
        Stream<String> stringStream =  list.stream().map(x -> x.toUpperCase());

        /// 3 Sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> customSortedStream = list.stream().sorted( (a,b) -> a.length() - b.length());

        Stream<String> customSortedStreamWithoutLambdaExpression = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        /// 4 Distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());
        list.stream().filter(x -> x.startsWith("A")).distinct().forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 5 Limit
        System.out.println(Stream.iterate(1 , x -> x + 1).limit(200).count());

        /// 6 Skip
        System.out.println(Stream.iterate(1 , x -> x + 1).skip(10).limit(100).count());

        /// 7 Peek ( It is similar to for each but it is Intermediate operation)
        System.out.println(Stream.iterate(1 , x -> x + 1).skip(50).limit(100)
                        .peek(x -> System.out.println(x))
                        .count());

        /// 8 Flat Map
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(listOfLists.get(2).get(0));

        System.out.println(listOfLists
                .stream()
                .flatMap(x -> x.stream())
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList()));

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences
                .stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList()));

    }
}

