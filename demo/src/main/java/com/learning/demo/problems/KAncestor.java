package com.learning.demo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KAncestor {
    private int n;
    private int[] parent;
    private int[][] anc;
    private int[] d;
        public KAncestor(int n, int[] parent) {
            this.n = n;
            this.parent = parent;
            int h = 20;
            anc = new int[n][h+1];
            d = new int[n];
            

            for(int i=0; i <= n-1; i++){
                anc[i][0] = parent[i];
            }
            
            for(int j =1; j<=h; j++ ){
                for(int i=0; i <= n-1; i++){
                    
                    if(anc[i][j-1] == -1){ 
                        anc[i][j] = -1;
                    }else{
                        anc[i][j] = anc[anc[i][j-1]][j-1];
                    }
                    
                }
            }
            
        }
        
        public int getKthAncestor(int node, int k) {
            // k - {d[]}

            // k - 5, j = 2, 
            int i = 1;
            int j = 0;
            while(k < i){
                i = i * 2;
                j++;
            }
            int janc = anc[node][j];

            for(int l=0; l<k-i; l++){
                janc = anc[janc][0];
                if(janc == -1){
                    return -1;
                }
            }
            return janc;
        }


        public static void main(String[] args) {
            int[] p = new int[]{-1,2,3,0}; //new int[]{0, 0, 0, 1, 1, 2, 2}
            int N = 4;
            KAncestor ancestor = new KAncestor(N, p);
            System.out.println(ancestor.anc);
            System.out.println(ancestor.getKthAncestor(2, 3));
        }
}
