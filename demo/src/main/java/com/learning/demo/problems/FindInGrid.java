package com.learning.demo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindInGrid {
    
    List<int[]> search(char[][] grid, String target){
        char[] arr = target.toCharArray();
        int k = arr.length;
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> list = new ArrayList<>();
        int[][] dp = new int[m+1][n+1];
        int count = 0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                char ch = grid[i][j];
                if(i==0 && j==0){
                    if(arr[0] == grid[i][j]){
                        dp[i][j] = 1;
                    }
                }else if(i==0){
                    // no up
                    int prev = dp[i][j-1];
                    if(arr[prev] == grid[i][j]){
                        dp[i][j] = prev + 1;
                    }
                }else if(j==0){
                    // no left
                    int prev = dp[i-1][j];
                    if(arr[prev] == grid[i][j]){
                        dp[i][j] = prev + 1;
                    }
                }else{
                    int prev = Math.max(dp[i-1][j] , dp[i][j-1]);
                    if(arr[prev] == grid[i][j]){
                        dp[i][j] = prev + 1;
                    }
                }


                if(ch == arr[count] && (i==0 || j ==0)){
                    dp[i][j] = 1;
                    list.add(new int[]{i,j});
                    count++;
                }else if(dp[i-1][j] + dp[i][j-1] > 0 && grid[i][j] == arr[count]){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) + 1;
                    list.add(new int[]{i,j});
                    count++;
                }else{
                    count = 0;
                    list.clear();
                }

                if(count == k-1){
                    return list;
                }
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        
    }
}
/**
You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'],
    ['b', 'a', 'c', 'c', 'e', 's', 'c', 'n'],
    ['a', 'l', 't', 'e', 'w', 'c', 'e', 'w'],
    ['a', 'l', 'o', 's', 's', 'e', 'c', 'c'],
    ['w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'],
    ['i', 'b', 'w', 'o', 'w', 'w', 'o', 'w']
]
word1_1 = "access"      # [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
word1_2 = "balloon"     # [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]

word1_3 = "wow"         # [(4, 3), (5, 3), (5, 4)] OR 
                        # [(5, 2), (5, 3), (5, 4)] OR 
                        # [(5, 5), (5, 6), (5, 7)]
                          
word1_4 = "sec"         # [(3, 4), (3, 5), (3, 6)] OR 
                        # [(3, 4), (3, 5), (4, 5)]    

word1_5 = "bbaal"       # [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]


grid2 = [
  ['a'],
]
word2_1 = "a"

grid3 = [
    ['c', 'a'],
    ['t', 't'],
    ['h', 'a'],
    ['a', 'c'],
    ['t', 'g']
]
word3_1 = "cat"
word3_2 = "hat"

grid4 = [
    ['c', 'c', 'x', 't', 'i', 'b'],
    ['c', 'a', 't', 'n', 'i', 'i'],
    ['a', 'x', 'n', 'x', 'p', 't'],
    ['t', 'x', 'i', 'x', 't', 't']
]
word4_1 = "catnip"      # [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                        # [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]


All test cases:

search(grid1, word1_1) => [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
search(grid1, word1_2) => [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]
search(grid1, word1_3) => [(4, 3), (5, 3), (5, 4)] OR 
                          [(5, 2), (5, 3), (5, 4)] OR 
                          [(5, 5), (5, 6), (5, 7)]
search(grid1, word1_4) => [(3, 4), (3, 5), (3, 6)] OR
                          [(3, 4), (3, 5), (4, 5)]                           
search(grid1, word1_5) => [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]

search(grid2, word2_1) => [(0, 0)]

search(grid3, word3_1) => [(0, 0), (0, 1), (1, 1)]
search(grid3, word3_2) => [(2, 0), (3, 0), (4, 0)]

search(grid4, word4_1) => [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                          [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
**/
/**import java.io.*;
import java.util.*;

public class Solution {
  
  
  public static Map<Character, Integer> reinitialize(String target){
    Map<Character, Integer> map = new HashMap<>();
    char[] arr = target.toCharArray();
    for(char ch: arr){
      Integer count = map.get(ch);
      if(count == null){
        map.put(ch, 1);
      }else{
        map.put(ch, count+1);
      }
      
    }
    return map;
  }
  public static String find(String[] list, String target){
    Map<Character, Integer> map = reinitialize(target);
    
    for(String str : list){
      char[] e = str.toCharArray();
      int count = 0;
      for(char ch : e){
        Integer occurence = map.get(ch);
        if(occurence != null){
          count++;
          occurence = occurence -1;  
          if(occurence == 0){
            map.remove(ch);
          }else{
            map.put(ch, occurence);  
          }      
          
        }
      }
      if(count == e.length){
        return str;
      }
      count = 0;
      map = reinitialize(target);
    }
    
    return "";
    
  }
  
  public static void main(String[] argv) {
    char[][] grid1 = {
  {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
  {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
  {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
  {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
  {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
  {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'},
};
String word1_1 = "access";
String word1_2 = "balloon";
String word1_3 = "wow";
String word1_4 = "sec";
String word1_5 = "bbaal";

char[][] grid2 = {
  {'a'},
};
String word2_1 = "a";

char[][] grid3 = {
  {'c', 'a'},
  {'t', 't'},
  {'h', 'a'},
  {'a', 'c'},
  {'t', 'g'},
};
String word3_1 = "cat";
String word3_2 = "hat";

char[][] grid4 = {
  {'c', 'c', 'x', 't', 'i', 'b'},
  {'c', 'a', 't', 'n', 'i', 'i'},
  {'a', 'x', 'n', 'x', 'p', 't'},
  {'t', 'x', 'i', 'x', 't', 't'},
};
String word4_1 = "catnip";
  }
}
*/