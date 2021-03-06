package com.shirish.graphs;

import java.util.ArrayList;

public class CycleDetectionDFSDirected8 {
/*
    1 ---> 2 ---> 3 --------> 4 ---> 5
           ^                  |      ^
           |                  |      |
           7                  |_ >6 _|
         /   \
      8   ---> 9
*/

    public static void main(String args[]) {
        int vertex = 9;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= vertex; i++)
            adjList.add(new ArrayList<Integer>());

        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(4).add(6);
        adjList.get(6).add(5);
        adjList.get(7).add(2);
        adjList.get(7).add(8);
        adjList.get(8).add(9);
        adjList.get(9).add(7);

        for (int i = 1; i <= vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        boolean isCyclePresent = isCyclePresent(adjList, vertex);
        System.out.println("isCyclePresent  " + isCyclePresent);


    }

    private static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adjList, int vertex) {
        int [] visited = new int [vertex+1];
        int [] dfsVisited = new int [vertex+1];

        for (int i = 1; i <= vertex; i++) {
            if(visited[i] == 0)
            {
                if(isCyclePresentDfs(i, visited, dfsVisited, adjList))
                    return true;
            }
        }
        return false;



    }

    private static boolean isCyclePresentDfs(int i, int[] visited, int[] dfsVisited, ArrayList<ArrayList<Integer>> adjList) {
        int node = i;
        visited[node] = 1;
        dfsVisited[node] = 1;
        for(int it : adjList.get(node))
        {
            if(visited[it] == 0) {
                if (isCyclePresentDfs(it, visited, dfsVisited, adjList))
                    return true;
            }
            else if(dfsVisited[it]==1)
                return true;
        }
        dfsVisited[node] = 0;
        return false;


    }

}
