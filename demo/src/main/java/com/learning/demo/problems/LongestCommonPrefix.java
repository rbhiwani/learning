package com.learning.demo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";

        Map<Integer, String> map = new HashMap<>();
        boolean flag = true;
        int counter = 0;
        while(flag && strs.length > 0){
            
            for(int i=0; i<strs.length; i++){
                String temp = strs[i];
                if(temp.length() > counter){
                    String ch = temp.substring(counter,counter+1);
                
                    if(map.get(counter) == null){
                        map.put(counter, ch);            
                    }else if(!map.get(counter).equals(ch)){
                        map.remove(counter);
                        flag = false;
                        break;
                    }
                }
                
                
            }
            counter++;
        }

        prefix = map.values().stream().collect(Collectors.joining());
        return prefix;
    }

    public static void main(String[] args) {
        
        String[] arr = new String[]{};
        System.out.println(longestCommonPrefix(arr));
    }
}
