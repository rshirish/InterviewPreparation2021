package com.shirish.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInBsfUnDirectedGraph {
    /*
            1-----2
            |    /|
            |  /  |
            0     3
    */


    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        int vertex = 4, edges = 4;

        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);

        adjList.get(1).add(0);
        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(0);
        adjList.get(2).add(3);

        adjList.get(3).add(2);

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + "---->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        bfs(adjList, vertex);

    }

    private static void bfs(List<List<Integer>> adjList, int vertex) {
        boolean isCyclePresent = false;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (visited[i] == false) {
                isCyclePresent = bfsOnComponent(new Node(0, -1), queue, visited, adjList);
            }
        }
        System.out.println("Is Cycle Present : "+isCyclePresent);
    }

    private static boolean bfsOnComponent(Node source, Queue<Node> queue, boolean[] visited, List<List<Integer>> adjList) {
        queue.add(source);
        visited[source.getValue()] = true;
        while(!queue.isEmpty())
        {
            Integer prev = queue.peek().getPrev();
            Integer current = queue.peek().getValue();
            queue.poll();
            for(Integer node : adjList.get(current))
            {
                if (visited[node] == false) {
                 visited[node] = true;
                 queue.add(new Node(node, current));
                }
                //cycle present
                //6--7--8
                //|______|
                else if(prev != node){
                    return true;
                }
                //cycle not present
                //6-----7
                //|_____|
            }

        }
return false;

    }

    private static class Node {
        public Node(int value, int prev) {
            this.value = value;
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getPrev() {
            return prev;
        }

        public void setPrev(int prev) {
            this.prev = prev;
        }

        int value;
        int prev;


    }
}
