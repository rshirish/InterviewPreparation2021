package com.shirish.practice.graph;

import java.util.ArrayList;

public class CycleDetectionDfsDirected {

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
        int [] visited = new int[vertex+1];
        int [] visitedDfs = new int[vertex+1];
        for (int i = 1; i <= vertex; i++) {
             if(visited[i] == 0)
             {
                 if(isCyclePresentInComponent(i, visited, visitedDfs, adjList))
                 {
                     return true;
                 }
             }
        }
        return true;
    }

    private static boolean isCyclePresentInComponent(int source, int[] visited, int[] visitedDfs, ArrayList<ArrayList<Integer>> adjList) {
        int node = source;
        visited[source] = 1;
        visitedDfs[source] = 1;
        for(int it : adjList.get(source))
        {
            if(visited[it] == 0)
            {
                if(isCyclePresentInComponent(it, visited, visitedDfs, adjList))
                {
                    return true;
                }
            }
            else if(visitedDfs[it]==1)
            {
                return true;
            }
        }
        visitedDfs[source] = 0;
        return false;

    }
}
