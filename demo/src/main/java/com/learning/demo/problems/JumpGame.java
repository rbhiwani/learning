package com.learning.demo.problems;

public class JumpGame {
    
    static boolean canJump(int[] nums){

        int lastGI = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(i + nums[i] >= lastGI){
                lastGI = i;
            }
        }

        if(lastGI == 0){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
