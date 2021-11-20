package com.shirish.practice.graph;

import java.util.*;

public class BFS {

    /*
1---2---3
    |   |    4---6
    |   |
    7---5

     */


    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int vertex = 7, edges = 6;
        for (int i = 0; i < vertex + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(7);

        adjList.get(3).add(2);
        adjList.get(3).add(5);

        adjList.get(4).add(6);

        adjList.get(4).add(6);

        adjList.get(5).add(3);
        adjList.get(5).add(7);

        adjList.get(6).add(4);

        adjList.get(7).add(2);
        adjList.get(7).add(5);

        for(int i = 1; i< vertex+1 ; i++)
        {
            System.out.print(i + " ----> ");
            for(int j =0; j < adjList.get(i).size(); j++)
            {
                System.out.print(adjList.get(i).get(j)+ "  ");
            }
            System.out.println();
        }
        bsf(adjList, vertex);
    }

    private static void bsf(List<List<Integer>> adjList, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[vertex+1];

        List<Integer> bsfList = new ArrayList<>();
        for(int i = 1; i< vertex+1 ; i++) {
            if(visited[i] == false)
            {
                bsfList = bfsOnComponent(i, queue, visited, bsfList, adjList);
            }

            System.out.println("bsf list : " + Arrays.toString(bsfList.toArray()));

        }
    }

    private static List<Integer> bfsOnComponent(int source, Queue<Integer> queue, boolean[] visited, List<Integer> bsfList, List<List<Integer>> adjList) {
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty())
        {
            Integer node  = queue.poll();
            bsfList.add(node);
            for(Integer value : adjList.get(node))
            {
                if(visited[value] == false)
                {
                    queue.add(value);
                    visited[value] = true;
                }
            }
        }
        return bsfList;

    }


}
