package com.learning.demo.problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[] dx = new int[]{-1,1,-1,1,0,0,1,-1};
        int[] dy = new int[]{-1,1,1,-1,1,-1,0,0};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] front = q.remove();

            if(front[0] == n-1 && front[1] == n-1){
                return front[2];
            }

            for(int i=0; i<8; i++){
                int x = front[0] + dx[i];
                int y = front[1] + dy[i];
                if(x>=0 && x < n && y >=0 && y < n && grid[x][y] == 0 && !visited[x][y]){
                    q.add(new int[]{x,y,front[2]+1});
                    visited[x][y] = true;
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}
