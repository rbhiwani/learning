package com.learning.demo.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger{

    public static int romanToInt(String s) {
        Map<Character, Integer> symbols = 
        Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 
        'D', 500, 'M', 1000);
        // L | C > X
        char[] arr = s.toCharArray();

        //Map<Character, Integer> temp = new HashMap<>();
        char prevChar = arr[0];
        int count = 0;
        int result = 0;
        for(int i=0; i<arr.length; i++){
            if(prevChar == arr[i]){
                prevChar = arr[i];
                count++;
            }else if(symbols.get(prevChar) < symbols.get(arr[i])){
                //temp.put(prevChar, count-1);
                result += symbols.get(prevChar) * (count-1);
                result += symbols.get(arr[i]) - symbols.get(prevChar);
                count = 0;
            }else{
                result += symbols.get(prevChar) * count;
                prevChar = arr[i];
                
                count = 1;
                
                //temp.put(prevChar, count);
            }

            

        }


        /*int total = 0;
        for(Map.Entry<Character, Integer> entry : temp.entrySet()){
            total += symbols.get(entry.getKey()) * entry.getValue();
        }*/
        
        return result + (symbols.get(prevChar) * count);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XLV"));
    }
}