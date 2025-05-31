package com.streams.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamQuestions5 {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("Shivam" , "Shweta" , "Akshay" , "abc" , "def" , "ghi");
        // Find those whose length is greater than 3
        List<String> listUpdated =  name.stream().filter(x -> x.length() > 3).collect(Collectors.toList());

        System.out.println(listUpdated);

        // Squaring and Sorting Number
        List<Integer> arr = Arrays.asList(5,2,9,1,6);
        arr = arr.stream().map(x -> x * x).sorted( (x,y) -> y - x ).collect(Collectors.toList());
        System.out.println(arr);


        //  Example - Summing Values
        List<Integer> brr = Arrays.asList(1,2,3,4,5);
        System.out.println(brr.stream().reduce( (x , y) -> x + y).get());

        // Example : Counting Occurences of a Character
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        List<String> drr = Arrays.asList("ab" , "bc" ,"ca" , "ab" ,"ab" ,"bc");
        System.out.println(drr.stream().filter(x -> x.equals("ab")).count());

        // Stateful and stateless
        // Stateless - It does not matter with next number for example - Map
        // Stateful = It take consideration of all the elements , for example - Sorted


    }
}
