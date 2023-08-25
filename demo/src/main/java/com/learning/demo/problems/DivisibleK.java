package com.learning.demo.problems;

import java.util.ArrayList;
import java.util.List;

public class DivisibleK {
    
    public static List<List<String>> map = new ArrayList<>();
    public static int solve(int[][] grid, int k, int i, int j, int sum, List<String> list){
        int m = grid.length-1;
        int n = grid[0].length-1;
        if(i > m || j > n){
            return 0;
        }
        sum += grid[i][j];
        if(i == m && j == n){
            
            if(sum%k == 0){
                map.add(list);
                return 1;
            }else{
                return 0;
            }
        }
        list.add(i +"," + j + ":" + sum);
        int moveDown = solve(grid, k, i+1, j, sum, list) ;
        //map.put(i +"+" + j, sum);
        int moveRight = solve(grid, k, i, j+1, sum, list); 
        return moveDown + moveRight;

    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{5,2,4},{3,0,5},{0,7,2}};
        System.out.println(solve(grid, 3, 0, 0, 0, new ArrayList<String>()));
        System.out.println(map);
    }
}
