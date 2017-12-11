package org.sample.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private List<Long> visited = new ArrayList<Long>();
	private Stack<Vertex<Integer>> stack = new Stack<Vertex<Integer>>();
	
	
	public Stack<Vertex<Integer>> sort(Graph<Integer> graph) {
		
		for(Vertex<Integer> vertex : graph.getAllVertex()) {
				if(visited.contains(vertex.getId())) continue;
				dfs(vertex);
		}
		
		return stack;
	}
	
	// dfs
	public void dfs(Vertex<Integer> vertex) {
		
		if(vertex == null) return;

		visited.add(vertex.getId());
		
		for(Vertex<Integer> currentVertex : vertex.getAdjacentVertexes()) {
			if(visited.contains(currentVertex.getId())) {
				continue;
			}
			dfs(currentVertex);
		}

		stack.push(vertex);
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
		
		// adjacency matrix
		
		
		TopologicalSort obj = new TopologicalSort();
		
		
		// print 
		Stack<Vertex<Integer>> result = obj.sort(graph);
		GraphUtil.print(result);
		
	}
	
}
