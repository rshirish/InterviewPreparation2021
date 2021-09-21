package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimAlgorithmEfficient {

    public static void main(String args[])
    {
        int vertex = 5;
        ArrayList<ArrayList<NodePC>> adjList = new ArrayList<ArrayList<NodePC> >();

        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<NodePC>());

        adjList.get(0).add(new NodePC(1, 2));
        adjList.get(1).add(new NodePC(0, 2));

        adjList.get(1).add(new NodePC(2, 3));
        adjList.get(2).add(new NodePC(1, 3));

        adjList.get(0).add(new NodePC(3, 6));
        adjList.get(3).add(new NodePC(0, 6));

        adjList.get(1).add(new NodePC(3, 8));
        adjList.get(3).add(new NodePC(1, 8));

        adjList.get(1).add(new NodePC(4, 5));
        adjList.get(4).add(new NodePC(1, 5));

        adjList.get(2).add(new NodePC(4, 7));
        adjList.get(4).add(new NodePC(2, 7));

        for (int i = 0; i < vertex; i++) {

            System.out.print(i + "---->");

            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j).getV() + " - " + adjList.get(i).get(j).getWeight() + ", ");
            }
            System.out.println();
        }

        int [] parent  = getMST(vertex, adjList);

        System.out.println("Result : "+ Arrays.toString(parent));
        for(int i = 1;i<vertex;i++) {
            System.out.println(parent[i] + " - " + i);
        }

    }

    private static int[] getMST(int vertex, ArrayList<ArrayList<NodePC>> adjList) {

        boolean [] mst = new boolean[vertex];
        int [] parent = new int[vertex];
        int [] key = new int[vertex]; // we are storing weight here
        Arrays.fill(mst, false);
        Arrays.fill(key, Integer.MAX_VALUE);


        parent[0] = -1; //always initialise parent and key
        key[0] = 0;
        PriorityQueue<NodePC> pq = new PriorityQueue<>(vertex, new NodePC());
        pq.add(new NodePC(0, -1));

        while(!pq.isEmpty())
        {
            int u = pq.poll().getV();
            mst[u] = true;

            for(NodePC it : adjList.get(u))
            {
                if(mst[it.getV()]==false && it.getWeight() < key[it.getV()])
                {
                    key[it.getV()] = it.getWeight();
                    parent[it.getV()] = u;
                    pq.add(new NodePC(it.getV(), key[it.getV()] ));

                }
            }

        }


    return parent;


    }
}

class NodePC implements Comparator<NodePC>
{
    private int v;
    private int weight;

    NodePC(int _v, int _w) { v = _v; weight = _w; }

    NodePC() {}

    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(NodePC node1, NodePC node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
