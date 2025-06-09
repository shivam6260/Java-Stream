package com.streams.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        // feature introduced in Java 8
        // process collections of data in a functional and declarative manner
        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism

        //// What is stream ?
        // a sequence of elements supporting functional and declarative programing

        //// How to Use Streams ?
        // Source, intermediate operations & terminal operation

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // Find number of even number
        // 1st - Normal Approach
        int count = 0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i) % 2 == 0) {
                count = count + 1;
            }
        }
        System.out.println(count);

        System.out.println(list.stream().filter(x -> x%2 == 0).count());

        ////Creating Stream
        // 1 From Collections
        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        // 2 From Arrays
        String[] str = {"a","b","c"};
        Stream<String> stream1 = Arrays.stream(str);

        // 3 Using Stream.of
        Stream<String> stream2 = Stream.of("abc","def","ghi");

        // 4 Infinite Stream
        Stream.generate(() -> 1);
        Stream.iterate(1,x -> x + 1);

    }
}
