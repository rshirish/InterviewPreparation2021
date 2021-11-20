package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

1---2---3
    |   |    4---6
    |   |
    7---5

    */

public class DFS {

    public static void main(String[] args) {


        List<List<Integer>> adjList = new ArrayList<>();
        int vertex = 7, edges = 6;

        for(int i = 0; i <= vertex ; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(7);

        adjList.get(3).add(2);
        adjList.get(3).add(5);

        adjList.get(5).add(3);
        adjList.get(5).add(7);

        adjList.get(7).add(2);
        adjList.get(7).add(5);

        adjList.get(4).add(6);
        adjList.get(6).add(4);

        for(int i =1 ; i<= adjList.size()-1; i++)
        {
            System.out.print(i + " ----> ");
            for(int j =0; j< adjList.get(i).size(); j++)
            {
                System.out.print(adjList.get(i).get(j) + " ");

            }
            System.out.println();
        }

        dsf(adjList, vertex);

    }

    private static void dsf(List<List<Integer>> adjList, int vertex) {
        boolean [] visited = new boolean[vertex +1];
        List<Integer> dfsList = new ArrayList<>();
        for(int i =1 ; i<= adjList.size()-1; i++)
        {
            if(visited[i] == false)
            {
                dfsList = dfsOfComponent(i, visited, dfsList, adjList );
            }
        }
        System.out.println("dfx list : " + Arrays.toString(dfsList.toArray()));
    }

    private static List<Integer> dfsOfComponent(int source, boolean[] visited, List<Integer> dfsList, List<List<Integer>> adjList) {
        visited[source] = true;
        dfsList.add(source); // dont forget
        for(Integer  node : adjList.get(source))
        {
            if(visited[node] == false)
            {
                dfsOfComponent(node, visited, dfsList, adjList);
            }
        }
        return dfsList;
    }
}
