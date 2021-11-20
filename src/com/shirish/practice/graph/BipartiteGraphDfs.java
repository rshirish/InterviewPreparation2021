package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDfs {

    /*

    0---1---2---3--4
        |         /|
        |     /    |
        6 /        5
*/

    public static void main(String args[]) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
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


        for (int i = 0; i < n; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }


        boolean isBipartite = isBipartite(adjList, n);
        System.out.println("isBipartite  " + isBipartite);


    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int vertex) {
        int[] color = new int[vertex];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertex; i++) {
            if (color[i] == -1) {
                return isBipartiteComponent(color, i, adjList);
            }
        }
        return false;
    }

    private static boolean isBipartiteComponent(int[] color, int source, ArrayList<ArrayList<Integer>> adjList) {
        color[source] = 1;
        for (int node : adjList.get(source)) {
            if (color[node] == -1) {
                color[node] = 1 - color[source];
                if (!isBipartiteComponent(color, node, adjList))
                    return false;
            } else if (color[node] == color[source]) {
                return false;
            }
        }
        return true;
    }
}
