package org.sample.algo.dp;


/**
 * 
 * Timing Complexity: O(e * f^2) where e is number of eggs and f is number of floors
 * Space Complexity: O(e * f) 
 * 
 * Observations:
 * 1. If for a given number of floors, supply of eggs is infinite, number of minimum attempts
 * will reach log2 (f). In other words, it becomes a binary search variation.
 * 
 * 2. With limited supply of eggs, it'll go with binary search ...
 */
public class EggDropping {

	public int[][] result;
	
	public int getMinAttempts(int floor, int eggs) {
		
		//int[][] result = new int[eggs + 1][floor + 1];
		result = new int[eggs + 1][floor + 1];
		
		for(int i = 1; i <= floor; i++) {
			result[1][i] = i;
		}
		 
		
		for(int countEgg = 2; countEgg <= eggs; countEgg++) {
			
			for(int countFloor = 1; countFloor <= floor; countFloor++) {
				
				int minAttempt = Integer.MAX_VALUE;
				
				if(countEgg > countFloor) {
					result[countEgg][countFloor] = result[countEgg - 1][countFloor];
					continue;
				}
				
				for(int intermFloor = 1; intermFloor <= countFloor; intermFloor++) { // intermediate floor
					
					boolean broken = false; // tracing the floors
					//int maxAttempt = -1; // tracing the floors
					
					// case 1: egg breaks at the intermediate floor
					int attempt1 = 1 + result[countEgg - 1][intermFloor - 1];
					
					// case 2: egg doesn't break at the intermediate floor
					int attempt2 = 1 + result[countEgg][countFloor - intermFloor];
					
					// max attempt at the intermediate floor
					int maxAttempt = Math.max(attempt1, attempt2);
					
					if(attempt1 < attempt2) {
						broken = true;
					} else if (attempt1 > attempt2){
						broken = false;
					}
							
					if(minAttempt > maxAttempt) {
						System.out.println("minAttempt: "+minAttempt+", maxAttempt: "+maxAttempt+", minAttemptFloor: "+intermFloor + ", broken: "+broken+", total floor: "+countFloor + ", total eggs: "+countEgg);
						minAttempt = maxAttempt;
					}
				}
				
				// storing the result for countEgg and countFloor
				result[countEgg][countFloor] = minAttempt;
				//System.out.println("minAttempt: "+minAttempt+" from floor "+minAttemptFloor+" with total floor as "+floor);
			}
		}
		
		
		// print result
		/*System.out.println("result matrix: ");
		for(int i = 0; i <= eggs; i++) {
			for(int j = 0; j <= floor; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}*/
		
		return result[eggs][floor];
	}
	
	
	public static void main(String[] args) {
		EggDropping eggDropping = new EggDropping();
		//System.out.println("min attempt (2 eggs, 6 floors): "+eggDropping.getMinAttempts(6, 2));
		System.out.println("min attempt (3 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 3));
		//System.out.println("min attempt (4 eggs, 10 floors): "+eggDropping.getMinAttempts(10, 4));
		//System.out.println("min attempt (4 eggs, 50 floors): "+eggDropping.getMinAttempts(50, 4));
		
		/*int count = 1;
		int eggs = 3; 
		int currentFloor = eggDropping.getMinAttempts(100, 3);
		System.out.println("Attempt "+(count++)+ " at floor: "+currentFloor);
		int currentEggs = eggs;
		while(currentEggs > 1) {
			currentFloor = eggDropping.result[currentEggs - 1][currentFloor - 1];
			System.out.println("Attempt "+(count++)+ " at floor: "+currentFloor);
			currentEggs--;
		}
		
		System.out.println("linear search starts from "+currentFloor);*/
		
		//System.out.println("min attempt (3 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 3));
		/*System.out.println("min attempt (2 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 2));
		
		System.out.println("min attempt (4 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 4));
		System.out.println("min attempt (4 eggs, 200 floors): "+eggDropping.getMinAttempts(200, 4));
		System.out.println("min attempt (4 eggs, 1000 floors): "+eggDropping.getMinAttempts(1000, 4));
		System.out.println("min attempt (8 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 8));
		System.out.println("min attempt (20 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 20));
		System.out.println("min attempt (50 eggs, 100 floors): "+eggDropping.getMinAttempts(100, 50));
		System.out.println("min attempt (50 eggs, 1000 floors): "+eggDropping.getMinAttempts(1000, 50));
		System.out.println("min attempt (500 eggs, 1000 floors): "+eggDropping.getMinAttempts(1000, 500));*/
		
	}
}
