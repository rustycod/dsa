package org.sample.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortAllPaths {

	private List<Long> visited = new ArrayList<Long>();
	private Stack<Vertex<Integer>> stack = new Stack<Vertex<Integer>>();
	private List<Vertex<Integer>> sources = new ArrayList<Vertex<Integer>>();
	private List<List<Long>> listPaths = new ArrayList<List<Long>>();
	private Map<String, Integer> mapEdgeCount = new HashMap<String, Integer>();
	
	private int count = 1;
	
	/**
	 * This function will fetch all the possible paths of a DAG.
	 * Source vertices of given DAG are not known.
	 * 
	 * @param graph this is the given DAG
	 *  
	 */
	public void getAllPaths(Graph<Integer> graph) {
		
		/* For this problem, source vertices of given DAG not provided, 
		 * that's why we get any one topologically sorted path */
		TopologicalSort obj = new TopologicalSort();
		Stack<Vertex<Integer>> result = obj.sort(graph);
		System.out.print("Topological sort of given DAG: ");
		GraphUtil.print(result);
		System.out.println();
		
		int totalPaths = 0;
		
		// Topological sort of given DAG must contain all the vertices,
		// so need to iterate in order to find the source vertex and 
		// number of source vertices could be one or multiple
		while(!result.isEmpty()) {
			
			Vertex<Integer> currentVertex = result.pop();
			
			if(visited.contains(currentVertex.getId())) { 
				continue; // it can't be a source, because it was found in one of 
				// paths found as yet
			}
			
			// sources of given DAG
			sources.add(currentVertex);
			totalPaths += count;
			count = 1; // reset
			
			stack = new Stack<Vertex<Integer>>(); // reset
			visited = new ArrayList<Long>(); // reset
			dfs(currentVertex);
		}
		
		System.out.println("Given DAG has following source vertices: "+sources);
		System.out.println("Given DAG has following number of paths: "+totalPaths);
		System.out.println("List of all the paths: "+listPaths);

		
		// check which paths have at least one unique edge
		getUniqueEdges();
		for(List<Long> path : listPaths) {
			
			
			boolean doesUniqueEdgeExist = hasUniqueEdge(path); 
			if(doesUniqueEdgeExist) {
				System.out.println("Path " + path + " has unique edge!");
			} else {
				System.out.println("Path " + path + " does NOT have unique edge!!!");
			}
		}
	}
	
	
	// dfs
	public void dfs(Vertex<Integer> vertex) {
		
		visited.add(vertex.getId());
		stack.push(vertex);
		
		if(vertex.getAdjacentVertexes().size() == 0) {
			System.out.println("Path: "+stack);
			
			// for junit purpose
			List<Long> list = new ArrayList<Long>();
			GraphUtil.print(stack, list);
			listPaths.add(list);
			
			
			return; // reached vertex that doesn't have any other outgoing paths
		}

		
		// count
		count *= vertex.getAdjacentVertexes().size();
		
		for(Vertex<Integer> currentVertex : vertex.getAdjacentVertexes()) {
			if(stack.contains(currentVertex.getId())) { // to prevent cycle
				continue; // This if condition is not required for DAG though
			}
			dfs(currentVertex);
			stack.pop();
		}
		
		
	}
	
	
	// find the unique edge in a path
	public void getUniqueEdges() {
		
		for(List<Long> path : listPaths) {
			
			int vertexCount = path.size();
			int count = 1;
			
			while(count < vertexCount) {
				String key = path.get(count - 1) + "->" + path.get(count);
				count++;
				
				if(mapEdgeCount.get(key) != null) {
					mapEdgeCount.put(key, mapEdgeCount.get(key) + 1);
				} else {
					mapEdgeCount.put(key, 1);
				}
			}
		}
		
		
		System.out.println("mapEdgeCount: "+mapEdgeCount);
	}
	
	
	
	
	public boolean hasUniqueEdge(List<Long> path) {

		int vertexCount = path.size();
		int count = 1;

		while(count < vertexCount) {
			String key = path.get(count - 1) + "->" + path.get(count);
			count++;

			if(mapEdgeCount.get(key) == 1) {
				return true;
			}
		}

		return false;
	}
	
	
	public static void main(String[] args) {
		
		Graph<Integer> graph = new Graph<Integer>(true);
		graph.addEdge(1,  3);
		graph.addEdge(2,  3);
		graph.addEdge(2,  4);
		graph.addEdge(3,  5);
		graph.addEdge(4,  6);
		graph.addEdge(5,  6);
		graph.addEdge(6,  7);
		
		TopologicalSortAllPaths obj = new TopologicalSortAllPaths();
		obj.getAllPaths(graph);
		
		
	}
	
	
	
	
}
