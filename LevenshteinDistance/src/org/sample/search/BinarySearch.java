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

	// ------------------------------------------------------------------------------------------------
	
    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

		int mid = 0;

        /*
         * In binary search iteration method ‘=’ in condition “start <= end” is required as there could 
         * be only one number present and mid should point to this. 
         * ‘Return’ in mid condition 'if(arr[mid] == target)' will help in terminating the while loop in this case.
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
        
        // base condition
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

	// ------------------------------------------------------------------------------------------------

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

	public int[] searchOccurences(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
    

        // find first occurence first
        int firstPosition = getFirstOccurence(nums, target, start, end);

        // find last occurence then
        int lastPosition = getLastOccurence(nums, target, start, end);

        return new int[]{firstPosition, lastPosition};
    }


    private int getFirstOccurence(int[] nums, int target, int start, int end) {

        if(start > end) return -1;

        int mid = start + (end - start) / 2;
    
        // important: 
        // 1. corner case when first elment in the array is the first occurence.
        // 2. fist condition "must be" the first one as mid-1 will get out of bounds.
        // 3. second condition checks that 'mid' is the first occurrence of the target
        if((mid == 0 && nums[mid] == target) 
            || (nums[mid] == target && nums[mid-1] != target)) {
                return mid;
        } 

        // important: in case target is equal, push the processing towards left to find first occurance
        if(nums[mid] >= target) { // change in condition
            return getFirstOccurence(nums, target, start, mid - 1);
        } else {
            return getFirstOccurence(nums, target, mid + 1, end);
        }
    }


    private int getLastOccurence(int[] nums, int target, int start, int end) {

        if(start > end) return -1;

        int mid = start + (end - start) / 2;
    
        // important: 
        // 1. corner case when last elment in the array is the last occurence.
        // 2. fist condition "must be" the first oneas mid+1 will get out of bounds.
        // 3. second condition checks that 'mid' is the last occurrence of the target
        if((mid == (nums.length -1 ) && nums[mid] == target) 
            || (nums[mid] == target && nums[mid+1] != target)) {
                return mid;
        } 

        // important: in case target is equal, push the processing towards right to find last occurance
        if(nums[mid] > target) { // change in condition
            return getLastOccurence(nums, target, start, mid - 1);
        } else {
            return getLastOccurence(nums, target, mid + 1, end);
        }
    }

	// iterative version
	public int[] searchOccurencesIteratively(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
    

        // find first occurence first
        int firstPosition = getFirstOccurenceIteratively(nums, target, start, end);

        // find last occurence then
        int lastPosition = getLastOccurenceIteratively(nums, target, start, end);

        return new int[]{firstPosition, lastPosition};
    }


    private int getFirstOccurenceIteratively(int[] nums, int target, int start, int end) {

        int mid = 0;

        while(start <= end) {

            mid = start + (end - start) / 2;
    
            // important: 
            // 1. corner case when first elment in the array is the first occurence.
            // 2. fist condition "must be" the first one as mid-1 will get out of bounds.
            // 3. second condition checks that 'mid' is the first occurrence of the target
            if((mid == 0 && nums[mid] == target) 
                || (nums[mid] == target && nums[mid-1] != target)) {
                    return mid;
            } 

            // important: in case target is equal, push the processing towards left to find first occurance
            if(nums[mid] >= target) { // change in condition
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }


    private int getLastOccurenceIteratively(int[] nums, int target, int start, int end) {

        int mid = 0;

        while(start <= end) {

            mid = start + (end - start) / 2;
    
            // important: 
            // 1. corner case when last elment in the array is the last occurence.
            // 2. fist condition "must be" the first oneas mid+1 will get out of bounds.
            // 3. second condition checks that 'mid' is the last occurrence of the target
            if((mid == (nums.length -1 ) && nums[mid] == target) 
                || (nums[mid] == target && nums[mid+1] != target)) {
                    return mid;
            } 

            // important: in case target is equal, push the processing towards right to find last occurance
            if(nums[mid] > target) { // change in condition
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }   
	
	// ------------------------------------------------------------------------------------------------
	
	// O(log n)
	public int searchInRotatedSortedArray(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        while(start <= end) {

            mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;

            // important: left side is sorted
            if(nums[mid] >= nums[start]) { // TODO check the equality case
                if(target >= nums[start] && target < nums[mid]) {
                    // target is on left side
                    end = mid - 1;
                } else {
                    // target is on right side
                    start = mid + 1;
                }

            } else { // important: right side is sorted
                if(target <= nums[end] && target > nums[mid]) {
                    // target is on right side
                    start = mid + 1;
                } else {
                    // target is on right side
                    end = mid -1;
                }
            }
        }

        return -1;
        
    }

	// ------------------------------------------------------------------------------------------------

	    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) {
        	return -1;
        }
        
        if(nums.length == 1) return nums[0];
    	
    	// array is sorted already
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        while(start <= end) {

            mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            if(nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
        
    }

	// ------------------------------------------------------------------------------------------------
	
	public int findMaximumInBitonicArray(int[] arr) {
        
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        
        
        while(start < end) {
            
            mid = start + (end - start) / 2;
            
            if(mid > 0 && mid < (arr.length - 1)) { // important edge case
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                    return arr[mid];
                }
            
                if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
                    start = mid + 1;
                } 
            
                if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {
                    end = mid - 1;
                }                
            } else if(mid == 0 && arr[mid] > arr[mid+1]) {
                return arr[mid];
            } else if(mid == (arr.length - 1) && arr[mid] > arr[mid-1]) {
                return arr[mid];
            } 

        }
        
        return arr[start];
        
    }


	
	
}
