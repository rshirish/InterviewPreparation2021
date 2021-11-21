package com.shirish.practice.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDirectedGraph {

    public static void main(String args[]) {
        int vertex = 6;
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<Pair>());

        adjList.get(0).add(new Pair(1, 2));
        adjList.get(0).add(new Pair(4, 1));
        adjList.get(1).add(new Pair(2, 3));
        adjList.get(2).add(new Pair(3, 6));
        adjList.get(4).add(new Pair(2, 2));
        adjList.get(4).add(new Pair(5, 4));
        adjList.get(5).add(new Pair(3, 1));
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");

            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j).getV() + " - " + adjList.get(i).get(j).getWeight() + ", ");
            }
            System.out.println();
        }

        int[] result = getShortestPathArrayForAllNodes(vertex, adjList);
        for (int i = 0; i < vertex; i++) {
            if (result[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(result[i] + " ");
        }

    }

    private static int[] getShortestPathArrayForAllNodes(int vertex, ArrayList<ArrayList<Pair>> adjList) {
        Stack stack = new Stack();
        int[] distance = new int[vertex];
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false) {
                getTopologicalStack(visited, i, stack, adjList);

            }
        }
        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = (int) stack.pop();
            if (distance[node] != Integer.MAX_VALUE) ; //IMP STEP
            {
                for (Pair it : adjList.get(node)) {
                    if (distance[node] + it.getWeight() < distance[it.getV()]) {
                        distance[it.getV()] = distance[node] + it.getWeight();
                    }
                }
            }

        }

        return distance;
    }


    private static void getTopologicalStack(boolean[] visited, int source, Stack stack, ArrayList<ArrayList<Pair>> adjList) {
        visited[source] = true;
        for (Pair it : adjList.get(source)) {
            if (visited[it.getV()] == false) {
                getTopologicalStack(visited, it.getV(), stack, adjList);
            }
        }
        stack.push(source);
    }
}


class Pair {
    private int v;
    private int weight;

    Pair(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

}




