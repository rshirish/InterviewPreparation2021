package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {


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

        int[] res = getTopoSortArray(vertex, adjList);
        System.out.println("Topological Sort : " + Arrays.toString(res));

        if (check(adjList, vertex, res) == true)
            System.out.println("1");
        else
            System.out.println("0");

    }

    private static boolean check(ArrayList<ArrayList<Integer>> adjList, int V, int[] res) {

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;

        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < V; i++) {
            for (int v : adjList.get(i)) {
                System.out.println("Map of i " +map[i]);
                System.out.println("Map of v " +map[v]);
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }

    private static int[] getTopoSortArray(int vertex, ArrayList<ArrayList<Integer>> adjList) {
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
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSortArray[index] = node;
            index++;
            for(int it: adjList.get(node))
            {
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.add(it);
            }
        }
        return topoSortArray;
    }
}
