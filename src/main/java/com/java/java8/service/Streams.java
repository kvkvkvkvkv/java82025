package com.java.java8.service;

import java.util.List;

public class Streams {

    public void print(List<Integer> nums) {

        //static method reference
        nums.forEach(Streams::printInteger); //Method Reference
    }

    public static void printInteger(int val) {
        System.out.println(val);
    }
}
