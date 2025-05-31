package com.streams.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialsList = list.stream().map(x -> factorial(x)).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        factorialsList = list.parallelStream().map(x -> factorial(x)).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with Parallel  stream: " + (endTime - startTime) + " ms");

        // Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets

        // Cumulative Sum [1,2,3,4,5] => [1,3,6,10,15]
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int[] temp = new int[1];
        arr = arr.stream().map( x -> {
            x = x + temp[0];
            temp[0] = x;
           return x;
        }).collect(Collectors.toList());
        System.out.println(arr);


        // This will not give the correct result as we are using parallel stream means
        // multiple threads are changing this which is impacting real time data
        List<Integer> brr = Arrays.asList(1, 2, 3, 4, 5);
        int[] temp2 = new int[1];
        brr = brr.parallelStream().map( x -> {
            x = x + temp2[0];
            temp2[0] = x;
            return x;
        }).collect(Collectors.toList());
        System.out.println(brr);



    }

    public static long factorial(int n) {
        long res = 1;
        for(int i = 2;i<=n;i++) {
            res *= i;
        }
        return res;
    }
}
