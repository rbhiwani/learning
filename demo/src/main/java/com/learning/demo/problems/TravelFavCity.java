package com.learning.demo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class TravelFavCity{

/**
 * InnerTravelFavCity
 */
public static class City implements Comparable<City>{

    private String name;
    private Map<City, Integer> neighbours;
    private int distance;

    public City(String name, Map<City, Integer> neighbours, int distance){
        this.distance = distance;
        this.name = name;
        this.neighbours = neighbours;
    }

    void addNeighbour(City city, int distance){
        this.neighbours.put(city, distance);
    }

    /* 
    @Override
    public boolean equals(Object city){
        return city == null ? false : this.name.equals(((City)city).name);
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode();
    }
    */

    @Override
    public String toString(){
        String adjNodes = this.neighbours != null ? this.neighbours.entrySet().stream()
        .map(entry -> entry.getKey().name + " : " + entry.getValue())
        .collect(Collectors.joining(",", "[", "]")) : "[]";
        return "[name: " + this.name 
        + ", neighbours: " + adjNodes
        + ", distance: " + this.distance
        + "]";
    }

    @Override
    public int compareTo(City o) {
        return this.distance - o.distance;
    }
}

public static void solve(City source){
    Set<String> favs = new HashSet<>(Arrays.asList("1","2"));
    Queue<City> q = new PriorityQueue<>();
    Set<City> visited = new HashSet<>();
    q.add(source);

    int mdc = Integer.MAX_VALUE;
    String fastcity = "0";
    while(!q.isEmpty()){
        City front = q.remove();
        for(Map.Entry<City, Integer> entry : front.neighbours.entrySet()){
            City neighbour = entry.getKey();
            int weight = entry.getValue();
            if(!visited.contains(neighbour)){
                if(neighbour.distance > front.distance + weight){
                    neighbour.distance = front.distance + weight;
                }
                q.add(neighbour);
            }
        }
        System.out.println("Check queue elements: " + q);

        if(favs.contains(front.name) && front.distance < mdc){
            mdc = front.distance;
            fastcity = front.name;
        }
        visited.add(front);
        

    }

    System.out.println(visited);
    System.out.println(fastcity);

}    
// A - {B,C,D}
// B - {}
/*
 * A -- > (20) B
 * 
 * C ---> (10) B
 * 
 */

public static void main(String[] args) {
    int cities = 4;
    int[][] grid =  new int[][]{
        {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
    };
    City A = new City("0", new HashMap<>(), 0);
    City B = new City("1", new HashMap<>(), 0);
    City C = new City("2", new HashMap<>(), 0);
    A.addNeighbour(B, 100);
    B.addNeighbour(A, 100);
    B.addNeighbour(C, 100);
    C.addNeighbour(B, 100);
    A.addNeighbour(C, 500);
    C.addNeighbour(A, 500);
    Map<Integer, City> map = new HashMap<>();
    int source = 0;
    for(int i=0; i<grid.length; i++){

        City city = map.get(grid[i][0]);
        if(map.get(grid[i][0]) == null){
            if(grid[i][0] == source){
                city = new City(grid[i][0] + "", new HashMap<>(), 0);
            }else{
                city = new City(grid[i][0] + "", new HashMap<>(), Integer.MAX_VALUE);
            }
        }
        

        City neighbour = map.get(grid[i][1]);
        if(map.get(grid[i][1]) == null){
            if(grid[i][1] == source){
                neighbour = new City(grid[i][1] + "", new HashMap<>(), 0);
            }else{
                neighbour = new City(grid[i][1] + "", new HashMap<>(), Integer.MAX_VALUE);
            }
        }
        city.addNeighbour(neighbour, grid[i][2]);
        neighbour.addNeighbour(city, grid[i][2]);

        map.put(grid[i][0], city);
        map.put(grid[i][1], neighbour);

    }

    City src = map.get(source);

    System.out.println(map);

    solve(src);
}

}