package com.learning.demo.problems;

public class LCS {
    
    public static int longestCommonSubsequence(String text1, String text2) {
        
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        
        if(text1.substring(0,1).equals(text2.substring(0,1))){
            return 1+longestCommonSubsequence(text1.substring(1), text2.substring(1));
        }else{
            return Math.max(longestCommonSubsequence(text1.substring(1), text2),longestCommonSubsequence(text1, text2.substring(1)));
        }
    }

    public static int lcsBottomUp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcsBottomUp("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}
