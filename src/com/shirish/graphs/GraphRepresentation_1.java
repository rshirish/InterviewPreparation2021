package com.shirish.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentation_1 {
	
    /*
     *     4
     *     |
     * 1---2---3
     * |_______|
     * 
     */
	public static void main(String[] args) {
      
		List<List<Integer>> adjList = new ArrayList<>();
		int vertex = 4, edges = 4;
		
		for(int i = 0; i <= vertex ; i++)
		{
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(3);
		
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		
		adjList.get(3).add(2);
		adjList.get(3).add(1);
		
		adjList.get(4).add(2);
		
		for(int i =1 ; i<= adjList.size()-1; i++)
		{
			System.out.print(i + "---->");
			for(int j =0; j< adjList.get(i).size(); j++)
			{   
				System.out.print(adjList.get(i).get(j) + " ");
				
			}
			System.out.println();
		}
		
		
	}
	
	/*
	 * Output:
	 * 1---->2 3 
       2---->1 3 4 
       3---->2 1 
       4---->2 
	 * 
	 */

}
