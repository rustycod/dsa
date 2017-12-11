package org.sample.search;


/**
 * https://www.youtube.com/watch?v=KV-Eq3wYjxI
 * 
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 * 
 * optimization in youtube link
 * 
 */
public class TrappingRainWater {

	public int getRainWater(int[] arr) {
		
		int maxSeenLeft = 0;
		
		int[] maxSeenLeftArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > maxSeenLeft) {
				maxSeenLeft = arr[i];
				maxSeenLeftArr[i] = maxSeenLeft;
			} else {
				maxSeenLeftArr[i] = maxSeenLeft;
			}
		}
		
		
		System.out.println("maxSeenLeftArr: ");
		for(int i = 0; i < maxSeenLeftArr.length; i++) {
			System.out.print(maxSeenLeftArr[i] + " ");
		}
		System.out.println();
		
		
		int maxSeenRight = 0;
		
		int[] maxSeenRightArr = new int[arr.length];
		
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] > maxSeenRight) {
				maxSeenRight = arr[i];
				maxSeenRightArr[i] = maxSeenRight;
			} else {
				maxSeenRightArr[i] = maxSeenRight;
			}
		}
		
		System.out.println("maxSeenRightArr: ");
		for(int i = 0; i < maxSeenRightArr.length; i++) {
			System.out.print(maxSeenRightArr[i] + " ");
		}
		System.out.println();
		
		int rainWater = 0;
		
		for(int i = 0; i < arr.length; i++) {
			rainWater += Math.max(Math.min(maxSeenLeftArr[i], maxSeenRightArr[i]) - arr[i], 0);
		}
		
		return rainWater; 
	}
}
