package com.streams.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestions {
    public static void main(String[] args) {
        /// Basic Level (1-15)

        /// 1. How do you create a stream from a list of integers?
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream1 = list1.stream();

        /// 2. How do you convert a stream back to a list?
        List<Integer> list2 = stream1.collect(Collectors.toList());
        System.out.println(list2);

        /// 3. How do you find the count of elements in a stream?
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(list3.stream().count());

        /// 4. How do you filter even numbers from a list using streams?
        System.out.println(list3.stream().filter(x -> x % 2 == 0).count());
        System.out.println(list3.stream().filter(x -> x % 2 != 0).count());

        /// 5. How do you transform a list of strings to uppercase using streams?
        List<String> list4 = Arrays.asList("abc", "def", "ghi", "jkl", "mno");
        list4.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));

        /// 6. How do you sort a list of numbers using streams?
        List<Integer> list5 = Arrays.asList(2, 5, 7, 9, 1, 0, 2, 3);
        list5.stream().sorted().forEach(x -> System.out.print(x + " "));
        System.out.println();
        list5.stream().sorted().distinct().forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(list5);

        list5.stream().sorted((a, b) -> b - a).forEach(x -> System.out.print(x + " "));
        System.out.println();

        List<Integer> list6 = Arrays.asList(-2, 3, -4, 5);
        list6.stream().sorted((a, b) -> b * b - a * a).forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 7. How do you limit a stream to the first 5 elements?
        List<Integer> list7 = Arrays.asList(2, 5, 7, 9, 1, 0, 2, 3);
        list7.stream().limit(5).forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 8. How do you skip the first 3 elements in a stream?
        List<Integer> list8 = Arrays.asList(2, 5, 7, 9, 1, 0, 2, 3);
        list8.stream().skip(3).forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 9. How do you find the first element of a stream?
        System.out.println(list8.stream().findFirst().get());

        /// 10. How do you check if all elements in a stream match a given condition?
        /*
        This method takes a Predicate and returns true only if all elements
        in the stream satisfy the condition.If the stream is empty, allMatch() returns true by default.
         */
        List<Integer> list9 = List.of(2, 4, 6, 8, 10);
        boolean allEven = list9.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allEven);

        /// 11. How do you check if any element in a stream matches a given condition?
        List<Integer> list10 = List.of(2, 4, 7, 8, 10);
        boolean anyOdd = list10.stream().anyMatch(x -> x % 2 != 0);
        System.out.println(anyOdd);

        /// 12. How do you remove duplicate elements from a list using streams?
        List<Integer> list11 = Arrays.asList(2, 2, 2, 3, 3, 3, 4, 6, 6, 7, 7, 7);
        list11.stream().distinct().forEach(x -> System.out.print(x + " "));
        System.out.println();
        list11.stream().filter(x -> x % 2 == 0).distinct().forEach(x -> System.out.print(x + " "));
        System.out.println();

        /// 13.How do you collect elements from a stream into a Set?
        List<Integer> list12 = Arrays.asList(2, 2, 2, 3, 3, 3, 4, 6, 6, 7, 7, 7);
        Set<Integer> set = list12.stream().collect(Collectors.toSet());
        System.out.println(set);

        /// 14. How do you generate an infinite stream of random numbers?
        Stream.iterate(1 , x -> x + 1).limit(20).forEach(x -> System.out.println(x));

        /// 15. How do you create a stream from an array?
        String[] str = {"a","b","c"};
        Stream<String> stream2 = Arrays.stream(str);


        /// Intermediate Level (16-35)

    }
}

























