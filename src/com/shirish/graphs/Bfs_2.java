package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1---2---3
    |   |    4---6
    |   |
    7---5
    
    */
public class Bfs_2 {

	public static void main(String[] args) {

		List<List<Integer>> adjList = new ArrayList<>();
		int vertex = 7, edges = 6;
		
		for(int i = 0; i <= vertex ; i++)
		{
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(1).add(2);
		
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(2).add(7);
		
		adjList.get(3).add(2);
		adjList.get(3).add(5);
		
		adjList.get(5).add(3);
		adjList.get(5).add(7);
		
		adjList.get(7).add(2);
		adjList.get(7).add(5);
		
		adjList.get(4).add(6);
		adjList.get(6).add(4);
		
		for(int i =1 ; i<= adjList.size()-1; i++)
		{
			System.out.print(i + " ----> ");
			for(int j =0; j< adjList.get(i).size(); j++)
			{   
				System.out.print(adjList.get(i).get(j) + " ");
				
			}
			System.out.println();
		}
		
		bsf(adjList, vertex);

	}

	private static void bsf(List<List<Integer>> adjList, int vertex) {
		
		boolean [] visited = new boolean [vertex+1];
		Queue<Integer> queue = new  LinkedList<Integer>();
		
		for(int i =1 ; i<= adjList.size()-1; i++)
		{
		   List<Integer> bsf = new ArrayList<>();
		   if(visited[i] != true)   // componenets are not connected
		   {
			   bsf = bfsOfComponent(i, adjList, visited, queue, bsf);
		   }
		   System.out.println("bsf list : " +Arrays.toString(bsf.toArray()));
		}
		
		
	}

	private static List<Integer> bfsOfComponent(int source, List<List<Integer>> adjList, boolean[] visited,
		Queue<Integer> queue, List<Integer> bsf) {
		queue.add(source);
		visited[source] = true;
		
		while(!queue.isEmpty())
		{
			Integer node = queue.poll();
			bsf.add(node);   // put into the result list when you are removing from from the queue
			for(Integer adjNode : adjList.get(node))
			{
				if(visited[adjNode] == false)
				{
					queue.add(adjNode);
					visited[adjNode] = true;
				}
			}
		}
		
		return bsf;
	}

}
