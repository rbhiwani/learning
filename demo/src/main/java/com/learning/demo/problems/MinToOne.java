package com.learning.demo.problems;

public class MinToOne {
    

    static int minOne(int n){

        if(n <= 1){
            return 0;
        }

        if(n%3==0){
            return 1+minOne(n/3);
        }
        
        if(n%2==0){
            return 1+minOne(n/2);
        }

        

        return 1+minOne(n-1);

    }

    static int minTwo(int n){
        int[] dp = new int[n+1];
        if(n == 1 && n == 0){
            dp[n] = n;
        }
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            int div3 = Integer.MAX_VALUE;
            int div2 = Integer.MAX_VALUE;
            if(i%3==0){
                div3 = dp[i/3];
            }
            if(i%2==0){
                div2 = dp[i/2];
            }
                
            dp[i] = Math.min(dp[i-1], Math.min(div3, div2))+1;
            
        }

        return dp[n];
        

        

         

    }
    public static void main(String[] args) {
        System.out.println(minTwo(10));
    }
}
