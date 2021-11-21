package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
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

    private static boolean check(ArrayList<ArrayList<Integer>> adjList, int vertex, int[] res) {

        int[] map = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            map[res[i]] = i;
        }
        System.out.println(Arrays.toString(map));

        for (int i = 0; i < vertex; i++) {
            for (int j : adjList.get(i)) {
                System.out.println("Map of i " +map[i]);
                System.out.println("Map of j " +map[j]);
                if (map[i] > map[j]) return false;
            }
        }
        return true;


    }

    private static void dfs(boolean[] visited, Stack<Integer> stack, int source, ArrayList<ArrayList<Integer>> adjList) {
        visited[source] = true;
        for (int it : adjList.get(source)) {
            if (visited[it] == false) {
                dfs(visited, stack, it, adjList);
            }
        }
        stack.push(source);
    }

    private static int[] getTopoSortArray(int vertex, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertex; i++) {
            {
                if (visited[i] == false) {
                    dfs(visited, stack, i, adjList);
                }
            }
        }
        int[] result = new int[vertex];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index++;
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print(" " + result[i]);
        }

        return result;
    }

}
