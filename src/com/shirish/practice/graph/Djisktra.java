package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Djisktra {

    /*
             1 --- 2 --- 3
           /     /    /
          0    /     /
           \ /      /
             4 --- 5

     */


    public static void main(String args[]) {
        int vertex = 6;
        ArrayList<ArrayList<NodeD>> adjList = new ArrayList<ArrayList<NodeD>>();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<NodeD>());

        adjList.get(0).add(new NodeD(1, 2));
        adjList.get(0).add(new NodeD(4, 1));

        adjList.get(1).add(new NodeD(2, 3));
        adjList.get(2).add(new NodeD(3, 6));
        adjList.get(4).add(new NodeD(2, 2));
        adjList.get(4).add(new NodeD(5, 4));
        adjList.get(5).add(new NodeD(3, 1));
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");

            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j).getV() + " - " + adjList.get(i).get(j).getWeight() + ", ");
            }
            System.out.println();
        }

        int [] result = findShortestDistanceUsingDjisktra(0, adjList, vertex);
        for (int i = 0; i < vertex; i++)
        {
            if (result[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( result[i] + " ");
        }

    }

    private static int[] findShortestDistanceUsingDjisktra(int source, ArrayList<ArrayList<NodeD>> adjList, int vertex) {
        int [] distance = new int[vertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<NodeD> queue = new PriorityQueue<>(vertex, new NodeD());
        queue.add(new NodeD(source, 0));
        distance[source]=0;
        while(!queue.isEmpty())
        {
            NodeD node = queue.poll();
            for(NodeD it : adjList.get(node.getV()))
            {
                if(distance[node.getV()]+it.getWeight() < distance[it.getV()]) //
                {
                    distance[it.getV()] = distance[node.getV()]+it.getWeight();
                    queue.add(new NodeD(it.getV(),  distance[it.getV()] )); // REMEMBER THIS STEP
                }
            }
        }
        return distance;


    }
}

class NodeD implements Comparator<NodeD> {
    private int v;
    private int weight;

    NodeD(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    NodeD() {
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public int compare(NodeD node1, NodeD node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
