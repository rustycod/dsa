package org.sample.search;

//https://www.youtube.com/watch?v=CNVN76UWpBo
public class DutchNationalFlag {

	/*public void threeWayDNF(int[] arr) {
		
		int i = 0, j = 0;
		int k = arr.length - 1;
		
		while(j <= k) { // '=' is also required in this condition for the case where 0 is last element of array
			if(arr[j] == 2) {
				swap(arr, j, k);
					k--;
			} else if(arr[j] == 1) {
				j++;
			} else if(arr[j] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			}
		}
	}*/

	
	
	// first odd and then even
	public void segregateOddEvenNumbers(int[] arr) {
		
		int odd = 0;
		int even = arr.length - 1;
		
		while(true) {
			
			while(arr[odd]%2 != 0) {
				odd++;
			}
			
			while(arr[even]%2 == 0) {
				even--;
			}
			
			if(odd > even) return;
			
			// swap
			int temp = arr[odd];
			arr[odd] = arr[even];
			arr[even] = temp;
		}
	}

	
	public void threeWayDNF(int[] arr) {
		
		// i act as low pointer and k as high
		// current position of i and k denotes that values at their indices are yet to be resolved and so are considered invalid, and they are waiting for a swap.
		int i = 0, k = arr.length -1;
		
		// j is just behaving like a pointer moving from left to right
		// current value of j denotes that this value is currently being evaluated
		int j = 0;
		
		while(j <= k) { // '=' is also required in this condition for the case where 0 is last element of array
			
			// current value to be evaluated
			int currValue = arr[j];
			
			if(currValue == 0) {
				swap(arr, i, j);
				i++; j++; // j is done with this swap as values on left side to j will always be in order, j might get only 1 and not 2 with this swap
				// Extending it, values before j and after k will always be in order
			} else if (currValue == 1) { // this doesn't require any evaluation, so j simply moves to next position
				j++;
			} else { // currValue is 2
				swap(arr, j, k); // j is not done yet, as j might have 0, and not 1, in its place
				k--;
			}
			
		}
	}
	
	private void swap(int[] arr, int position1, int position2) {
		int temp = arr[position1];
		arr[position1] = arr[position2];
		arr[position2] = temp;
		
	}
	
	
	public void fourWayDNF(int[] arr) {
		
		int p = 0, q = 0, s = arr.length -1;
		
		// r is just behaving like a pointer moving from left to right
		// current value of r denotes that this value is currently being evaluated
		int r = 0;
		
		while(r <= s) { // '=' is also required in this condition for the case where 0 or 1 is last element of array
			
			// current value to be evaluated
			int currValue = arr[r];
			
			if(currValue == 0) {
				swap(arr, p, r);
				p++; // r is not done yet as it might get 1 with this swap
			} else if (currValue == 1) { 
				swap(arr, q, r);
				q++; 
				r++; // r is done as it will not get lower values with this swap 
			} else if (currValue == 2) { // this doesn't require any evaluation, so j simply moves to next position 
				r++; // In other words, with currValue as 2, sort order on left side or right side (after k) doesn't get disturbed 
			} else { // currValue is 3
				swap(arr, r, s);
				s--;
			}
			
		}
	}
	
	
	
	public void fiveWayDNF(int[] arr) {
		
		int a = 0, b = 0, c = 0, e = arr.length -1;
		
		// d is just behaving like a pointer moving from left to right
		// current value of d denotes that this value is currently being evaluated
		int d = 0;
		
		while(d <= e) { // '=' is also required in this condition for the case where 0, 1, 2 is last element of array
			
			// current value to be evaluated
			int currValue = arr[d];
			
			if(currValue == 0) {
				swap(arr, a, d);
				a++; 
			} else if (currValue == 1) { 
				swap(arr, b, d);
				b++; 
			} else if (currValue == 2) {
				swap(arr, c, d);
				c++; 
				d++; // d is done now
			} else if (currValue == 3) { // this doesn't require any evaluation, so j simply moves to next position
				d++;
			} else { // currValue is 4
				swap(arr, d, e);
				e--;
			}
			
		}
	}
	
}
