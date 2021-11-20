package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBfs {

    /*
    0---1---2---3--4
        |         /|
        |     /    |
        6 /        5
*/

    public static void main(String args[]) {
        int vertex = 7;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<Integer>());

        adjList.get(0).add(1);
        adjList.get(1).add(0);

        adjList.get(1).add(2);
        adjList.get(2).add(1);


        adjList.get(2).add(3);
        adjList.get(3).add(2);

        adjList.get(4).add(3);
        adjList.get(3).add(4);

        adjList.get(4).add(5);
        adjList.get(5).add(4);

        adjList.get(4).add(6);
        adjList.get(6).add(4);

        adjList.get(1).add(6);
        adjList.get(6).add(1);


        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        boolean isBipartite = isBipartite(adjList, vertex);
        System.out.println("isBipartite  " + isBipartite);
    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int vertex) {
        int[] color = new int[vertex];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(color, -1);
        for (int i = 0; i < vertex; i++) {
            if (color[i] == -1) {
                return checkIsBipartite(i, color, queue, adjList);
            }
        }
        return false;
    }

    private static boolean checkIsBipartite(int source, int[] color, Queue<Integer> queue, ArrayList<ArrayList<Integer>> adjList) {
        queue.add(source);
        color[source] = 1;

        while (!queue.isEmpty()) {
            int node = queue.peek();
            ;
            queue.poll();
            for (Integer it : adjList.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    queue.add(it);
                } else if (color[it] == color[node])
                    return false;
            }

        }
        return true;

    }
}
