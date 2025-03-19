package com.java.java8.service;

import java.util.List;

public class Streams {

    public void print(List<Integer> nums) {

        //static method reference
        nums.forEach(Streams::printInteger); //Method Reference
        nums.forEach(System.out::println); //inbuilt static method
        nums.stream()
                .filter(ele -> ele%2==0) //boolean logic only
                .forEach(System.out::println); //print even numbers

    }

    public static void printInteger(int val) {
        System.out.println(val);
    }
}
