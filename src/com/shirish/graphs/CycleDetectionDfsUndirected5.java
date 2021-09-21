package com.shirish.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDfsUndirected5 {
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

        boolean visited[] = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false) {
                System.out.println("Index : "+i);
                boolean isCyclePresent = isCyclePresent(i, -1, adjList, visited);
                System.out.println("Cycle present in component : "+isCyclePresent);

            }
        }

    }

    private static boolean isCyclePresent(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for(int it : adjList.get(node))
        {
            if(visited[it]==false)
            {
                if(isCyclePresent(it, node, adjList,visited))
                    return true;
            }
            else if(it != parent)
                return true;
        }
        return false;
    }
}

