package com.shirish.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

1---2---3
    |   |    4---6
    |   |
    7---5
    
    */
public class Dfs_3 {

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
		
		dsf(adjList, vertex);

	}

	private static void dsf(List<List<Integer>> adjList, int vertex) {
		
		boolean [] visited = new boolean [vertex+1];
		for(Integer i = 1; i<= adjList.size()-1; i++)
		{
			List<Integer> dfs = new ArrayList<>();
			if(!visited[i]==true)
			{
				dfs = dfsOfComponent(i, adjList, visited, dfs);
				System.out.println(Arrays.toString(dfs.toArray()));
			}

		}
		
		
	}

	private static List<Integer> dfsOfComponent(Integer source, List<List<Integer>> adjList, boolean[] visited,
			List<Integer> dfs) {
		dfs.add(source);
		visited[source] = true; //add and mark visited
		for(Integer adjNode : adjList.get(source))
		{
			if(visited[adjNode] == false)
			dfsOfComponent(adjNode, adjList, visited, dfs);
		}
		return dfs;
		
		
	}
}