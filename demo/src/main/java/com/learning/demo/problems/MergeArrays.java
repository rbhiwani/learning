package com.learning.demo.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];

        int i=0,j=0,k=0;
        while(i<m && j<n){
            int temp = 0;
            if(nums1[i] <= nums2[j]){
                temp = nums1[i];
                i++;
            }else{
                temp = nums2[j];
                j++;
            }
            
            arr[k] = temp;
            k++;
        }

        if(i<m){
            while(i<m){
                arr[k] = nums1[i];
                i++;
                k++;
            }
        }else if(j < n){
            while(j<n){
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }

        System.out.println(
            Arrays.stream(arr).mapToObj(num -> String.valueOf(num))
            .collect(Collectors.joining(","))
            );
         
    }


    public static void main(String[] args) {
        merge(new int[]{1,2,4}, 3, new int[]{2,5,6}, 3);
    }
}
