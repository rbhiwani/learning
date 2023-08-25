package com.models;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
    
    /**
     * Person
String name     */
    public record Person(String name) {
        public Person(String name){
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("Raj"));

        list.stream().forEach(System.out::println);

        String temp = "<xml><temp><x></x></temp>";
        System.out.println(temp.matches("(.)*<temp>(.)*</temp>"));

        String resource = "ALL-FUNDS";

        System.out.println(Pattern.matches("^[a-zA-Z0-9_]+$", resource));
    }
}
