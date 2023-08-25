package com.learning.demo.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubs {
    

    static void printSubs(String input, String output, List<String> list){
        if(input.length() == 0){
            System.out.println(output);
            list.add(output);
            return;
        }

        printSubs(input.substring(1), output + input.substring(0, 1), list);
        printSubs(input.substring(1), output, list);

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String output = "";
        printSubs("abc", output, list);
        System.out.println(list);
    }
}
