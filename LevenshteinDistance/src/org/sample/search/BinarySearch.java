package org.sample.search;

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
	
}
