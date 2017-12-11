package org.sample.practice.string;

public class Combination {

	public void combination(char[] arr, int[] cArr, char[] result, int index, int count) {
		
		while(index < arr.length) {
			
			if(cArr[index] == 0) {
				index++;
				continue;
			}
			
			result[count] = arr[index];
			cArr[index] -= 1;
			
			// print result
			String str = new String(result);
			str = str.substring(0, count + 1);
			System.out.println(str);
			
			combination(arr, cArr, result, index, count + 1);
			cArr[index] += 1;
			
			index++;
		}
	}
	
	
	public static void main(String[] args) {
		
		char[] arr = new char[]{'A', 'B', 'C'};
		int[] cArr = new int[]{2, 1, 1};
		char[] result = new char[4];
		
		Combination obj = new Combination();
		obj.combination(arr, cArr, result, 0, 0);
	}
}
