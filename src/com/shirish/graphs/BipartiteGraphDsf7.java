package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDsf7 {

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

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkDfs(i, adjList, color)) {
                    System.out.println("Array Result : "+Arrays.toString(color));
                    return false;
                }
            }

        }
        return true;

    }

    private static boolean checkDfs(int i, ArrayList<ArrayList<Integer>> adjList, int[] color) {
        for (Integer it : adjList.get(i)) {
            if (color[it] == -1) {
                color[it] = 1 - color[i];
                if (!checkDfs(it, adjList, color))
                    return false;
            } else if (color[it] == color[i])
                return false;
        }

        return true;
    }
}
