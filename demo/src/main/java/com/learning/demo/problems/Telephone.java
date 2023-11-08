package com.learning.demo.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Telephone {
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return Collections.emptyList();
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});


        Queue<String> q = new LinkedList<>();

        char[] arr = digits.toCharArray();
        for(char e : map.get(arr[0])){
            q.add(String.valueOf(e));
        }
        /**
        q -> [a,b,c]
        q ->[b,c,ad,ae,af]
        
         */
        while(!q.isEmpty() && q.peek().length() != arr.length){
            String element = q.remove();
            int index = element.length();
            char n = arr[index];
            for(char e : map.get(n)){
                q.add(element + String.valueOf(e));
            }

        }

        return q.stream().collect(Collectors.toList());
        
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
}
