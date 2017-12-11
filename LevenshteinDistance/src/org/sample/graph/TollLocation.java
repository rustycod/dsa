package org.sample.graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/*
 * Properties of DAG:
 * 
 * - Each Node will lead at least one path to destination (assumming there is only one destination in DAG)
 * - Each Node will come in at least one path from source (assumming there is only one source in DAG)
 * 
 * - This problem has to be for single source and single destination
 * 
 * - Algorithm: conflict occurs only in case where more than one paths scenario occurs
 * 
 * further enhancements:
 * - multiple direct paths between two vertices
 * - multiple sources and destincations
 * - utilize path matrices
 * 
 * */
public class TollLocation {

    private static final int INF = 1000000;

    public boolean findTollLocations(int[][] distanceMatrix, Map<String, Integer> tollMap) {
        
        int distance[][] = new int[distanceMatrix.length][distanceMatrix.length];
        int path[][] = new int[distanceMatrix.length][distanceMatrix.length];
        int toll[][] = new int[distanceMatrix.length][distanceMatrix.length];
        
        for (int i=0; i < distanceMatrix.length; i++) {
            for (int j=0; j< distanceMatrix[i].length; j++){
                distance[i][j] = distanceMatrix[i][j];
                if (distanceMatrix[i][j] != INF && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }
        
        
        System.out.println("distance matrix: ");
        printArr(distance);
        System.out.println("path matrix: ");
        printArr(path);
        
		GraphDFSAdjacencyMatrix g = new GraphDFSAdjacencyMatrix(distance);
		int[] arrSorted = g.DFS(0);
		System.out.println("topological sorted vertices: ");
		for(int index = 0; index < arrSorted.length; index++) {
			System.out.print(arrSorted[index] + " ");
		}
		System.out.println();
		
		
        
        int indexJunction = arrSorted.length - 1;
        boolean doesJunctionContainToll = false;
        
        for(int i = arrSorted.length - 2; i >= 0; i--) {
        	
        	System.out.println("Path calculation between "+arrSorted[i]+" and "+arrSorted[arrSorted.length - 1]);
        	
        	Set<Integer> set = new TreeSet<Integer>();
        	Map<String, Integer> pathMap = new HashMap<String, Integer>();
        	int numberOfParallelPathsFound = 0;

        	// directEdge case
        	int directEdge = distance[i][arrSorted.length - 1] ;
        	
        	if(directEdge < INF) { // directEdge exists
        		set.add(directEdge);
        		numberOfParallelPathsFound++;
        		pathMap.put(i+"->"+(arrSorted.length - 1), directEdge);
        	}
        	
        	System.out.println("directEdge ("+i+" to "+(arrSorted.length - 1)+"): "+directEdge);
        	
        	
        	// indirectEdge case
        	for(int j = i + 1; j < arrSorted.length - 1; j++) {
        		System.out.println("dis ("+i+", "+j+") : "+distance[i][j]);
        		System.out.println("dis ("+j+", "+(arrSorted.length - 1)+") : "+distance[j][arrSorted.length - 1]);
        		System.out.println("totol distance: "+(distance[i][j] + distance[j][arrSorted.length - 1]));
        		
        		int currentIndirectPathDistance = distance[i][j] + distance[j][arrSorted.length - 1];
        		if(currentIndirectPathDistance < INF && distance[i][arrSorted.length - 1] < currentIndirectPathDistance) {
        			distance[i][arrSorted.length - 1] = currentIndirectPathDistance;
        			System.out.println("path change 1: ("+i+" to "+(arrSorted.length - 1)+"): from "+distanceMatrix[i][arrSorted.length - 1] + " to "+distance[i][arrSorted.length - 1]);
        			path[i][j] = path[j][arrSorted.length - 1];
        		}
        		
        		if(currentIndirectPathDistance < INF) {
            		set.add(currentIndirectPathDistance);
            		pathMap.put(i+"->"+j+"->"+(arrSorted.length - 1), currentIndirectPathDistance);
            		numberOfParallelPathsFound++;
            		distance[i][arrSorted.length - 1] = currentIndirectPathDistance;
            		path[i][j] = path[j][arrSorted.length - 1];
            	}
        	}
        	
        	
        	if(set.size() == 1 && numberOfParallelPathsFound > set.size()) {
        		System.out.println("vertex "+arrSorted[i]+ " is a junction without toll!!");
        		indexJunction = i;
        		doesJunctionContainToll = false;
        	}
        	
        	
        	// determine whether path difference has occurred
        	if(set.size() > 1) {
        		System.out.println("multiple path ("+set.size()+") exists between "+arrSorted[i]+" and "+arrSorted[arrSorted.length - 1] + " .Conflict arises!");
        		
        		int pathCount = 1;
        		int max = -1;
        		for(int weight : set) {
        			if(weight > max) max = weight;
        			System.out.println((pathCount++) + ":" + weight);
        		}
        		
        		// time to freeze the path
        		System.out.println("pathMap: "+pathMap);

        		boolean doesSolutionExist = freezePath(pathMap, max, indexJunction, doesJunctionContainToll, distance, tollMap);
        		
        		if(doesSolutionExist == false) {
        			System.out.println("*** No Solution");
        			return false;
        		} 
        		
        		doesJunctionContainToll = true; // toll created
        		indexJunction = i;
        		System.out.println("vertex "+arrSorted[i]+ " is a junction!! time to freeze the path!");
        	}
        	
        	System.out.println("final path: ("+arrSorted[i]+" and "+arrSorted[arrSorted.length - 1]+"): "+distance[i][arrSorted.length - 1]);
        }
    	
        //printPath(path, 3, 2);
        //return distance;
        return true;
    }
    
    
    private boolean freezePath(Map<String, Integer> pathMap, int max, int indexJunction, boolean doesJunctionContainToll, int[][] distance, Map<String, Integer> tollMap) {
    	
    	for(Map.Entry<String, Integer> entry: pathMap.entrySet()) {
    		
    		if(entry.getValue() < max) {
    			
    			int diff = max - entry.getValue();
    			
    			String path = entry.getKey();
    			String[] vertex = path.split("->");
    			
    			    			
    			boolean isJunctionInPath = false;
    			for(int i = 1; i < vertex.length; i++) {
    				if(Integer.parseInt(vertex[i]) > indexJunction) {
    					System.out.println(Integer.parseInt(vertex[i-1]) + "->" + Integer.parseInt(vertex[i])+" has a toll (!!) of "+diff+ " set up now");
    					tollMap.put(vertex[i-1] + "->" + vertex[i], diff);
    					isJunctionInPath = true;
    					break;
    				} else if(Integer.parseInt(vertex[i]) != indexJunction) {
    					continue;
    				} else {
    					isJunctionInPath = true;
    					if(doesJunctionContainToll == true) {
    						return false;
    					}
    					System.out.println(Integer.parseInt(vertex[i-1]) + "->" + Integer.parseInt(vertex[i])+" has a toll of "+diff+ " set up now");
    					tollMap.put(vertex[i-1] + "->" + vertex[i], diff);
    					break;
    				}
    			}
    			
    			if(isJunctionInPath == false) {
    				System.out.println(Integer.parseInt(vertex[vertex.length - 2]) + "->" + Integer.parseInt(vertex[vertex.length - 1])+" has a toll (!) of "+diff+ " set up now");
    				tollMap.put(vertex[vertex.length - 2] + "->" + vertex[vertex.length - 1], diff);
    			}

    		}
    	}
    	
    	return true;
    }

    public void printPath(int[][] path, int start, int end) {
        if(start < 0 || end < 0 || start >= path.length || end >= path.length) {
            throw new IllegalArgumentException();
        }

        System.out.println("Actual path - between " + start + " " + end);
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(end);
        while (true) {
            end = path[start][end];
            if(end == -1) {
                return;
            }
            stack.addFirst(end);
            if(end == start) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }

        System.out.println();
    }

    
    public void printArr(int[][] arr) {
    	
    	for(int i = 0; i < arr.length; i++) {
    		for(int j = 0; j < arr.length; j++) {
    			System.out.print(arr[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
