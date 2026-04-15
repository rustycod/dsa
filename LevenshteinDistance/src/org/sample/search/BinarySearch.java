package org.sample.search;

// Time Complexity: O(log(n)) Using Binary Search
// Auxiliary Space: O(log(n)) due to recursive calls, otherwise iterative version uses Auxiliary Space of O(1).

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array1 = new int[]{1, 3, 5, 7, 8}; // ans 2
		System.out.println("result is: "+BinarySearch.binarySearch(array1, 5));
		
		int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7}; // ans -1
		System.out.println("result is: "+BinarySearch.binarySearch(array2, 0));
		
		int[] array3 = new int[]{10, 20}; // ans 1
		System.out.println("result is: "+BinarySearch.binarySearch(array3, 20));		
		
	}
	
    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

		int mid = 0;

        /*
         * In binary search iteration method ‘=’ in condition “start <= end” is required as there could 
         * be only one number present and mid should point to this. 
         * ‘Return’ in mid condition will help in terminating the while loop in this case.
         * 
         */
        
        while(start <= end) { 

			mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }                
        
        return -1;
    }


	public int searchRecursive(int arr[], int x, int start, int end) {
        
       if(start > end) return -1;
        
        int mid = start + (end - start) / 2;
    
        if(arr[mid] == x) {
            return mid;
        } else if(arr[mid] > x) {
            return searchRecursive(arr, x, start, mid - 1);
        } else {
            return searchRecursive(arr, x, mid + 1, end);
		}        
    }


	// O(n)
    // reuturn indices of first and last occurrances
    public int[] searchRange(int[] nums, int target) {

        int firstPositionIndex = -1;
        int lastPositionIndex = -1;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == target && firstPositionIndex == -1) {
                firstPositionIndex = i;
            } else if(nums[i] != target && firstPositionIndex != -1) {
                lastPositionIndex = i - 1;
                break;
            } 
        }

        // important corner case
        if(firstPositionIndex != -1 && lastPositionIndex == -1) {
            lastPositionIndex = nums.length - 1;
        }

        return new int[]{firstPositionIndex, lastPositionIndex}; 
        
    }

	// simple code if only count of occurrences is asked
	public int countAllOccurences(int[] arr, int target) {
    	int count = 0;
    	for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == target) {
            	count++;
        	}
    	}

    	return count;
	}

	public int searchInRotatedSortedArray(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        // first check array is in ascending or descending order
        // there are three cases:
        // 1. mid lies before pivot, it means mid is greater than start
        // 2. mid is after pivot, it means mid is smaller than start

        while(start <= end) {
            mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[start]) { // case 1: left side is sorted
                if(nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // case 2: right side is sorted
                if(nums[mid] > target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }


	
	
}
