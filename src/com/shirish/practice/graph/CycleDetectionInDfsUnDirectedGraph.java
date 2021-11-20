package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDfsUnDirectedGraph {

     /*
	1-----2
	|    /|
	|  /  |
	0     3

	5-----6
	|    /|
	|  /  |
	4     7

	Limitation of the algorithm : Only one cycle is detected in this algorithm

*/


    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        int vertex = 8, edges = 8;

        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);

        adjList.get(1).add(0);
        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(0);
        adjList.get(2).add(3);

        adjList.get(3).add(2);

        adjList.get(4).add(5);
        adjList.get(4).add(6);

        adjList.get(5).add(4);
        adjList.get(5).add(6);

        adjList.get(6).add(5);
        adjList.get(6).add(4);
        adjList.get(6).add(7);

        adjList.get(7).add(6);

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        boolean isCyclePresent = false;
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false) {
                isCyclePresent = isCyclePresent(i, -1, visited, adjList);
            }
        }

        System.out.println("Is Cycle Present : "+isCyclePresent);

    }

    private static boolean isCyclePresent(int source, int previous, boolean[] visited, List<List<Integer>> adjList) {
        visited[source] = true;
        for (Integer node : adjList.get(source)) {
            if (visited[node] == false) {
                if (isCyclePresent(node, source, visited, adjList)) ;
                return true;
            } else if (node != previous)
                return true;
        }
        return false;
    }
}
