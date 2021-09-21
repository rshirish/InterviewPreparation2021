package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionBfsUndirected4 {
/*	
	1-----2
	|    /|
	|  /  |
	0     3
	
*/
	public static void main(String[] args) {
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		int vertex = 4, edges = 4;
		
		for(int i =0; i< vertex; i++)
		{
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
		
		for(int i=0 ; i< vertex; i++)
		{
			System.out.print(i + "---->");
			for(int j=0; j< adjList.get(i).size() ; j++)
			{
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		boolean visited[] = new boolean[vertex];
		int [] parent = new int[vertex];
		
		Queue<Node> queue = new LinkedList<Node>();
		Node source = new Node (0, -1);

		
		boolean isCyclePresent = isCyclePresent(source, visited, queue,adjList);
		System.out.println("Cycle present status: "+isCyclePresent);
		
		
	}

private static boolean isCyclePresent(Node source, boolean[] visited, Queue<Node> queue, List<List<Integer>> adjList) {
	queue.add(source);
	visited[source.first] = true;
	
	while(!queue.isEmpty())
	{
		int par = queue.peek().second;
		int node = queue.peek().first;
		queue.remove();
		for(int it : adjList.get(node))
		{
			if(visited[it] == false)
			{
				queue.add(new Node(it, node));
				visited[it]=true;
			}
			else if(par != it)
				return true;
		}
	
	}
	
	return false;
}


}


	
class Node {
	int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
	
}