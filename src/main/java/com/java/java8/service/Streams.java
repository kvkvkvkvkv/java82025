package com.java.java8.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Streams {

    public void print(List<Integer> nums) {

        //static method reference
        log.info("All Numbers");
        nums.forEach(Streams::printInteger); //Method Reference

        log.info("All Numbers");
        nums.forEach(System.out::println); //inbuilt static method

        log.info("Even Numbers");
        nums.stream()
                .filter(ele -> ele%2==0) //boolean logic only simplified rep of method
                .forEach(System.out::println); //print even numbers

        log.info("Odd Numbers");
        nums.stream()
                .filter(ele -> ele%2!=0)
                .forEach(System.out::println);

        log.info("Square Numbers");
        nums.stream()
                .filter(ele -> ele%2 == 0)
                .map(ele -> ele*ele)
                .forEach(System.out::println);
    }

    public void printCourses(List<String> courses) {

        log.info("All Courses");
        courses.forEach(System.out::println);

        log.info("Only Phy");
        courses.stream()
                .filter(course -> course.contains("Phy"))
                .forEach(System.out::println);

        log.info(">7 length");
        courses.stream()
                .filter(course -> course.length()>7)
                .forEach(System.out::println);
    }

    public static void printInteger(int val) {
        System.out.println(val);
    }
}
