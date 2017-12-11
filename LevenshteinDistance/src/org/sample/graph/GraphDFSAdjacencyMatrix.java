package org.sample.graph;

public class GraphDFSAdjacencyMatrix {

	    private int vertices;   // No. of vertices
	 
	    // Adjacency matrix
	    private int[][] matrix;
	    
	    // sorted vertices
	    private int[] result;
	    
	    private int count = 0;
	    
	    // Constructor
		GraphDFSAdjacencyMatrix(int vertexCount) {
	        vertices = vertexCount;
	        matrix = new int[vertices][vertices];
	        result = new int[vertices];
	    }
	 
	    // Constructor
		GraphDFSAdjacencyMatrix(int[][] matrix) {
	        vertices = matrix.length;
	        this.matrix = matrix;
	        result = new int[vertices];
	    }
		
	    //Function to add an edge into the graph
	    void addEdge(int v, int w) {
	    	matrix[v][w] = 1;
	    }
	 
	    // A function used by DFS
	    void DFSUtil(int currentVertex, boolean visited[]) {

	    	// Mark the current node as visited and print it
	        visited[currentVertex] = true;
	        //System.out.print(currentVertex+" ");
	        result[count++] = currentVertex;
	 
	        // Recur for all the vertices adjacent to this vertex
	        for(int i = currentVertex; i < vertices; i++) {
	        	for(int j = i + 1; j < vertices; j++) {
	        		if(matrix[i][j] >= 1) {
	        			if (!visited[j]) {
	        				DFSUtil(j, visited);
	    	            }
	        			
	        		}
	        	}
	        }
	    }
	 
	    // The function to do DFS traversal. It uses recursive DFSUtil()
	    public int[] DFS(int v) {
	        // Mark all the vertices as not visited(set as
	        // false by default in java)
	        boolean visited[] = new boolean[vertices];
	 
	        // Call the recursive helper function to print DFS traversal
	        DFSUtil(v, visited);
	        
	        return result;
	    }
	 
}
