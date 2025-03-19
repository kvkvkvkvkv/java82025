package com.java.java8.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        int val = nums.stream()
                //.reduce(0, (a,b) -> a+b)
                .reduce(10, Integer::sum); //seed value sum starts with 10 //||se well reduce
        //aggregate and number from stream
        //10 1
        //11 2
        //13 3
        //16 4
        //20 5
        //25 6
        //31 7
        //38 8
        //46 9
        //55
        log.info("Add numbers = {}", val);

        int max = nums.stream()
                .reduce(0, (a,b) -> a>b?a:b);
        log.info("play reduce = {}", max);

        int sum = nums.stream()
                .map(ele -> ele * ele)
                .reduce(0, Integer::sum);
        log.info("Sum of Squares = {}", sum);


        int sum2 = nums.stream()
                .reduce(0, (x, y) -> x*x + y*y);
        log.info("Wrong Sum of Squares = {}, since it adds same square multiple times", sum2);

        log.info("Distinct");
        nums.stream()
                .distinct()
                .forEach(System.out::println);

        log.info("Sorted");
        nums.stream()
                .sorted()
                .forEach(System.out::println);

        log.info("Create new List");
        List<Integer> newList = nums.stream()
                .map(ele -> ele* ele)
                .toList();

        // intermediate and terminal operators
        // intermediate // returns stream always
        // terminal // optional or values non stream values
        // triggred with terminal operations only
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

        log.info("length of courses");
        courses.stream()
                .map(course -> course.length())
                .forEach(System.out::println);

        log.info("Sorted");
        courses.stream()
                .sorted()
                .forEach(System.out::println);

        log.info("Sorted comaparator natural order");
        courses.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        log.info("Sorted comaparator reverse order");
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        log.info("Sorted own");
        courses.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }

    public static void printInteger(int val) {
        System.out.println(val);
    }
}
