package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedUnweightedGraph {

     /*
            1 ------- 2
          /             \           7
         0                \       /   \
          \                 \   /      \
            3 --- 4 --- 5 --- 6  ------- 8

     */


    public static void main(String args[]) {
        int vertex = 9;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<Integer>());

        adjList.get(0).add(1);
        adjList.get(0).add(3);

        adjList.get(1).add(0);
        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(6);

        adjList.get(3).add(0);
        adjList.get(3).add(4);

        adjList.get(4).add(3);
        adjList.get(4).add(5);

        adjList.get(5).add(4);
        adjList.get(5).add(6);

        adjList.get(6).add(5);
        adjList.get(6).add(2);
        adjList.get(6).add(7);
        adjList.get(6).add(8);

        adjList.get(7).add(6);
        adjList.get(7).add(8);

        adjList.get(8).add(6);
        adjList.get(8).add(7);
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        int[] result = getShortestDistanceOfEveryNode(0, adjList, vertex);
        System.out.println("Shortest Distance Array " + Arrays.toString(result));
    }

    private static int[] getShortestDistanceOfEveryNode(int source, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[vertex];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int it : adjList.get(node)) {
                if (distance[node] + 1 < distance[it]) {
                    distance[it] = distance[node] + 1;
                    queue.add(it);
                }

            }
        }
        return distance;
    }
}
