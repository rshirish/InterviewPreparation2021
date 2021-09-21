package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDfs {
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
        if (check(adjList, vertex, res) == true)
            System.out.println("1");
        else
            System.out.println("0");

    }

    private static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;

        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                System.out.println("Map of i " +map[i]);
                System.out.println("Map of v " +map[v]);
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }


    private static int[] getTopoSortArray(int vertex, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false) {
                getTopoSortDfs(i, adjList, visited, stack);
            }
        }

        int[] result = new int[vertex];
        int ind = 0;
        while (!stack.isEmpty()) {
            result[ind++] = stack.pop();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print(" " + result[i]);
        }
        return result;
    }

    private static void getTopoSortDfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Integer it : adjList.get(node)) {
            if (visited[it] == false)
                getTopoSortDfs(it, adjList, visited, stack);

        }
        stack.push(node);
    }

}
