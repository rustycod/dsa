package org.sample.graph;

import java.util.List;
import java.util.Stack;

public class GraphUtil {

	// print 
	public static void print(Stack<Vertex<Integer>> stack) {
		
		if(stack.isEmpty()) return;

		Vertex<Integer> currentVertex = stack.pop();
		System.out.print(currentVertex.getId()+" ");
		print(stack);
		stack.push(currentVertex);
	}
	
	
	// print 
	public static void print(Stack<Vertex<Integer>> stack, List<Long> list) {
		
		if(stack.isEmpty()) return;

		Vertex<Integer> currentVertex = stack.pop();
		//System.out.print(currentVertex.getId()+" ");
		print(stack, list);
		list.add(currentVertex.getId());
		stack.push(currentVertex);
	}
}
