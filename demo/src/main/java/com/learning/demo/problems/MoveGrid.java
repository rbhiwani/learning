package com.learning.demo.problems;

public class MoveGrid {
    
    static int move(int m, int n, int[][] dp){

        if(m == 0 && n == 0){
            return dp[m][n];
        }

        if(m < 0 || n < 0){
            return -1;
        }

        if(dp[m][n] != 0){
            return dp[m][n];
        }

        int moveup = move(m-1, n, dp);
        int moveleft = move(m, n-1, dp);
        int output = 0;
        if(moveup >=0){
            output += moveup;
        }
        if(moveleft >= 0){
            output += moveleft;
        }
        dp[m][n] = output;
        return output;
        


    }

    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        System.out.println(move(2,2, dp));
    }
}
