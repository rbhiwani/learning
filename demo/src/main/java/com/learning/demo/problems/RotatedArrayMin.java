package com.learning.demo.problems;

public class RotatedArrayMin {
    
    static int search(int[] arr){
        //int index = -1;
        int n = arr.length;
        int s = 0;
        int e = n -1;
        int m = 0;
        

        while(s<=e){
            m = (s+e)/2;
            int prev = (m-1+n)%n;
            int next = (m+1)%n;
            if(arr[m] < arr[next] && arr[m] < arr[prev]){
                return arr[m];
            }

            if(arr[m] <= arr[e]){
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        
        return arr[m];
    }

    public static void main(String[] args) {
        
        System.out.println(search(new int[]{3,4,5,1,2}));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}));
    }
}
