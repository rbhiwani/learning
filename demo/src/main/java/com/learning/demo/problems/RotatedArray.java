package com.learning.demo.problems;

public class RotatedArray {
    
    static int search(int[] arr, int x){
        //int index = -1;
        int s = 0;
        int e = arr.length -1;
        int m = -1;

        while(s<=e){
            m = (s+e)/2;
            if(arr[m] == x){
                return m;
            }

            if(arr[m] <= arr[e]){
                if(x > arr[m] && x <= arr[e]){
                    s = m + 1;
                }else{
                    e = m - 1;
                }
            }else{
                if(x < arr[m] && x >= arr[s]){
                    e = m - 1;
                }else{
                    s = m + 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        
        System.out.println(search(new int[]{3,4,5,1,2}, 3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
    }
}
