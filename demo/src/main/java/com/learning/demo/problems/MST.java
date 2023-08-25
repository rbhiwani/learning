package com.learning.demo.problems;

import java.util.Arrays;

public class MST {

    public static void makeSet(int N, int[] parent){
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
    
    }
    
    public static int find(int i, int[] parent){
        while(parent[i] != i){
            i = parent[i];
        }
        return i;
    }
    
    public static int solve(int N, int[][] edges){
        int cost = 0;
        Arrays.sort(edges, 0, edges.length, (edge1, edge2) -> edge1[2] - edge2[2]);
        //List<int[]> list = Arrays.asList(edges);
        //list.forEach(edge -> System.out.println(Arrays.asList(edge).stream().map(e -> e[2]).collect(Collectors.toList())));
        int[] parent = new int[N+1];
        makeSet(N, parent);
        for(int i=0; i<edges.length; i++){
            int s = edges[i][0];
            int d = edges[i][1];

            int x = find(s, parent);
            int y = find(d, parent);

            if(x!=y){
                cost += edges[i][2];
                parent[x] = y;
            }
        }
        return cost;
    
    }
    
    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {1,2,4},
            {2,3,6},
            {3,4,2}
        };

        System.out.println(solve(4, edges));
    }
}