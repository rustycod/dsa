package org.sample.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TollLocationTest {
	
	private static final int INF = 1000000;
	
	@Test
	public void testTollLocation1() {

    	// case 3: this has solution
		System.out.println("*** testTollLocation1");
    	int[][] graph = {
                {0, 1, 1, 5}, // 0 is source
                {INF, 0, 1, 1},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}, // 3 is destination
        };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(!doesSolutionExist);
	}
	
	
	@Test
	public void testTollLocation2() {

    	// case 3: this has solution
		System.out.println("*** testTollLocation2");
    	int[][] graph = {
                {0, 1, 1, 1}, // 0 is source
                {INF, 0, 1, 1},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}, // 3 is destination
        };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        System.out.println("*** tollMap: "+tollMap);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("0->3", 2);
        expectedTollMap.put("1->3", 1);
        expectedTollMap.put("0->2", 1);
        
		GraphDFSAdjacencyMatrix g = new GraphDFSAdjacencyMatrix(graph);
		assertEquals(expectedTollMap, tollMap);
	}
	
	@Test
	public void testTollLocation3() {

    	// case 3: this has solution
		System.out.println("*** testTollLocation3");
    	int[][] graph = {
                {0, 1, 1, 5}, // 0 is source
                {INF, 0, 1, 2},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}, // 3 is destination
        };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("0->1", 2);
        expectedTollMap.put("0->2", 3);
        
        assertEquals(expectedTollMap, tollMap);
	}
	
	
	@Test
	public void testTollLocation4() {

		System.out.println("*** testTollLocation4");
    	int[][] graph = {
                {0, 1, 1, INF}, // 0 is source
                {INF, 0, 1, 1},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}, // 3 is destination
        };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("1->3", 1);
        expectedTollMap.put("0->2", 1);
        assertEquals(expectedTollMap, tollMap);
	}
	

	@Test
	public void testTollLocation5() {

		System.out.println("*** testTollLocation5");
		int[][] graph = {
	            {0,   1,   1, 1, INF},
	            {INF, 0, INF, INF, 1},
	            {INF, INF, 0, 1, 1},
	            {INF, INF, INF, 0, 1},
	            {INF, INF, INF, INF, 0}
	    };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("1->4", 1);
        expectedTollMap.put("0->3", 1);
        expectedTollMap.put("2->4", 1);
        assertEquals(expectedTollMap, tollMap);
	}
	

	@Test
	public void testTollLocation6() {

		System.out.println("*** testTollLocation6");
		int[][] graph = {
	            {0,   1,   1,   INF},
	            {INF, 0,  1,   1},
	            {INF, INF, 0,   1},
	            {INF, INF, INF, 0}
	    };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("0->2", 1);
        expectedTollMap.put("1->3", 1);
        assertEquals(expectedTollMap, tollMap);
	}

	
	@Test
	public void testTollLocation7() {

		System.out.println("*** testTollLocation7");
		int[][] graph = {
	            {0,   1,   1,   INF},
	            {INF, 0,  1,   INF},
	            {INF, INF, 0,   1},
	            {INF, INF, INF, 0}
	    };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("0->2", 1);
        assertEquals(expectedTollMap, tollMap);
	}

	
	/*@Test
	public void testTollLocation7() {

		System.out.println("*** testTollLocation7");
		int[][] graph = {
	            {0,   1,   1,   INF},
	            {INF, 0,  1,   INF},
	            {INF, INF, 0,   1},
	            {INF, INF, INF, 0}
	    };
    	
    	
        TollLocation tollLocation = new TollLocation();
        Map<String, Integer> tollMap = new HashMap<String, Integer>();
        boolean doesSolutionExist = tollLocation.findTollLocations(graph, tollMap);
        assertTrue(doesSolutionExist);
        
        Map<String, Integer> expectedTollMap = new HashMap<String, Integer>();
        expectedTollMap.put("0->2", 1);
        assertEquals(expectedTollMap, tollMap);
	}*/

}
