package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBfsDetectCycel {


    /*
          5 ----> 0 <----- 4
     d    |                |   d
          2-----> 3 -----> 1

     */
    public static void main(String args[]) {
        int vertex = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<Integer>());
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        boolean isCyclePresent = getTopoSortArray(vertex, adjList);
        System.out.println("Topological Sort - isCyclePresent: " + isCyclePresent);


    }



    private static boolean getTopoSortArray(int vertex, ArrayList<ArrayList<Integer>> adjList) {
        int [] topoSortArray = new int[vertex];
        int[] inDegree = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            inDegree[i]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
           int node=  queue.poll();
           count++;
            for(int it: adjList.get(node))
            {
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.add(it);
            }
        }
        return (count==vertex);
    }
}
