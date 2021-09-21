package com.shirish.graphs;

import java.util.*;

public class KruskalsAlgorithm {

    public static void main(String args[])
    {
        int vertex = 5;
        ArrayList<NodeAA> adj = new ArrayList<NodeAA>();


        adj.add(new NodeAA(0, 1, 2));
        adj.add(new NodeAA(0, 3, 6));
        adj.add(new NodeAA(1, 3, 8));
        adj.add(new NodeAA(1, 2, 3));
        adj.add(new NodeAA(1, 4, 5));
        adj.add(new NodeAA(2, 4, 7));

        getMinimumSpanningTree(adj, vertex);



    }

    private static void getMinimumSpanningTree(ArrayList<NodeAA> adj, int vertex) {
        int [] parent = new int[vertex];
        int [] rank = new int[vertex];

        for(int i=0; i< vertex; i++)
        {
            parent[i] =i;
            rank[i] =0;
        }
        Collections.sort(adj, new SortComparator());

        int mstCost = 0;
        List<NodeAA> mst = new ArrayList<>();

        for(NodeAA it : adj)
        {
            if(getParent(it.getU(), parent) != getParent(it.getV(), parent))
            {
                mstCost += it.getWeight();
                mst.add(it);
                getUnion(it.getU(), it.getV(), parent, rank);
            }
        }
        System.out.println(mstCost);
        for(NodeAA it: mst) {
            System.out.println(it.getU() + " " +it.getV());
        }



    }

    private static void getUnion(int u, int v, int[] parent, int[] rank) {
        u = getParent(u, parent);
        v = getParent(v, parent);

        if(rank[u]< rank[v])
        {
            parent[u] = v;
        } else if(rank[v] < rank[u])
        {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u] ++;
        }



    }

    private static int getParent(int node, int[] parent) {
             if(node == parent[node])
                 return node;
             else
                 return getParent(parent[node], parent);

    }


}

class NodeAA
{
    private int u;
    private int v;
    private int weight;

    NodeAA(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

    NodeAA() {}

    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

class SortComparator implements Comparator<NodeAA> {
    @Override
    public int compare(NodeAA node1, NodeAA node2)
    {
        if (node1.getWeight() < node2.getWeight())
            return -1;
        if (node1.getWeight() > node2.getWeight())
            return 1;
        return 0;

    }
}
