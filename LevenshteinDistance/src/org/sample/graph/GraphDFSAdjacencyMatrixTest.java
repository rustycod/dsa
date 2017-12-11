package org.sample.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphDFSAdjacencyMatrixTest {
	
	private static final int INF = 1000000;
	
	@Test
	public void test1() {
		
        GraphDFSAdjacencyMatrix g = new GraphDFSAdjacencyMatrix(4);
   	 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
 
		int[] expected = new int[]{0, 1, 2, 3};
		assertArrayEquals(expected, g.DFS(0));
	}
	
	
	@Test
	public void test2() {

		int[][] graph = { { 0, 1, 1, 5 }, // 0 is source
				{ INF, 0, 1, 1 }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 }, // 3
																			// is
																			// destination
		};

		GraphDFSAdjacencyMatrix g = new GraphDFSAdjacencyMatrix(graph);
		int[] expected = new int[] { 0, 1, 2, 3 };
		assertArrayEquals(expected, g.DFS(0));

	}
	
	
	@Test
	public void test3() {

		int[][] graph = {
				{0,   1,   1, 1, INF},
				{INF, 0, INF, INF, 1},
				{INF, INF, 0, 1, 1},
				{INF, INF, INF, 0, 1},
				{INF, INF, INF, INF, 0}
		};

		GraphDFSAdjacencyMatrix g = new GraphDFSAdjacencyMatrix(graph);
		int[] expected = new int[] { 0, 1, 2, 3, 4 };
		assertArrayEquals(expected, g.DFS(0));

	}
}
