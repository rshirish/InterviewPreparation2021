package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBsf6 {
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


        for(int i=0 ; i< vertex; i++)
        {
            System.out.print(i + "---->");
            for(int j=0; j< adjList.get(i).size() ; j++)
            {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }


        boolean isBipartite = isBipartite(adjList, vertex);
        System.out.println("isBipartite  " +isBipartite);


    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {
        int [] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i< n; i ++)
        {
            if(color[i] == -1)
            {
                if(!checkBsf(i,queue, adjList, color)) {
                    System.out.println("Array Result : "+Arrays.toString(color));
                    return false;
                }
            }

        }
        return true;

    }

    private static boolean checkBsf(int i, Queue<Integer> queue, ArrayList<ArrayList<Integer>> adjList, int[] color) {
        queue.add(i);
        color[i] = 1;

        while(!queue.isEmpty())
        {
            Integer node = queue.poll();
            for(Integer it : adjList.get(node))
            {
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    queue.add(it);
                }
                else if(color[it] == color[node])
                    return false;
            }
        }
        return true;



    }
}
