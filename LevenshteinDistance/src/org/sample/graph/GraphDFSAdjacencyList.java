package org.sample.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphDFSAdjacencyList {

	    private int V;   // No. of vertices
	 
	    // adjacency matrix
	    private int[][] adj;
	 
	    // Constructor
	    @SuppressWarnings("unchecked")
		GraphDFSAdjacencyList(int v) {
	        V = v;
	        adj = new int[v][v];
	    }
	 
	    //Function to add an edge into the graph
	    void addEdge(int v, int w) {
	        adj[v][w] = 1;  // Add w to v's list.
	    }
	 
	    // A function used by DFS
	    void DFSUtil(int v,boolean visited[])
	    {
	        // Mark the current node as visited and print it
	        visited[v] = true;
	        System.out.print(v+" ");
	 
	        // Recur for all the vertices adjacent to this vertex
	        for(int i = 0; i < adj[v].length; i++) {
	            if (!visited[i]) {
	            	//DFSUtil(adv[i], visited);
	            }
	                	        	
	        }

	    }
	 
	    // The function to do DFS traversal. It uses recursive DFSUtil()
	    void DFS(int v)
	    {
	        // Mark all the vertices as not visited(set as
	        // false by default in java)
	        boolean visited[] = new boolean[V];
	 
	        // Call the recursive helper function to print DFS traversal
	        DFSUtil(v, visited);
	    }
	 
	    public static void main(String args[]) {
	        GraphDFSAdjacencyList g = new GraphDFSAdjacencyList(4);
	 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.DFS(2);
	    }
}
