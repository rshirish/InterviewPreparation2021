package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimsAlgorithm {

    public static void main(String args[])
    {
        int vertex = 5;
        ArrayList<ArrayList<NodeP>> adjList = new ArrayList<ArrayList<NodeP> >();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<NodeP>());

        adjList.get(0).add(new NodeP(1, 2));
        adjList.get(1).add(new NodeP(0, 2));

        adjList.get(1).add(new NodeP(2, 3));
        adjList.get(2).add(new NodeP(1, 3));

        adjList.get(0).add(new NodeP(3, 6));
        adjList.get(3).add(new NodeP(0, 6));

        adjList.get(1).add(new NodeP(3, 8));
        adjList.get(3).add(new NodeP(1, 8));

        adjList.get(1).add(new NodeP(4, 5));
        adjList.get(4).add(new NodeP(1, 5));

        adjList.get(2).add(new NodeP(4, 7));
        adjList.get(4).add(new NodeP(2, 7));

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");

            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j).getV() + " - " + adjList.get(i).get(j).getWeight() + ", ");
            }
            System.out.println();
        }

        int [] parent  = getMST(vertex, adjList);

        System.out.println("Result : "+Arrays.toString(parent));

    }

    private static int[] getMST(int vertex, ArrayList<ArrayList<NodeP>> adjList) {

        boolean [] mst = new boolean[vertex];
        int [] parent = new int [vertex];
        int [] key = new int [vertex];
        Arrays.fill(mst, false);
        Arrays.fill(key, Integer.MAX_VALUE);

        parent[0] = -1;
        key[0] = 0;
        for(int i =0; i< vertex-1; i++)
        {
            int mini = Integer.MAX_VALUE, u=0;
            for(int v = 0; v< vertex; v++)
            {
                if(mst[v]==false && key[v] < mini)
                {
                    mini = key[v];
                    u = v;
                }
            }
            mst[u] = true;

            for(NodeP it: adjList.get(u))
            {
                if(mst[it.getV()]==false && it.getWeight() < key[it.getV()])
                {
                    key[it.getV()] = it.getWeight();
                    parent[it.getV()] = u;
                }
            }
        }
        for(int i = 1;i<vertex;i++) {
            System.out.println(parent[i] + " - " + i);
        }
        return parent;
    }
}

class NodeP
{
    private int v;
    private int weight;

    NodeP(int _v, int _w) { v = _v; weight = _w; }

    NodeP() {}

    int getV() { return v; }
    int getWeight() { return weight; }
}
