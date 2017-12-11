package org.sample.practice.string;

public class Permutation {

	public void permute(char[] arr, int[] cArr, char[] result, int count) {
		
		if(count == result.length) {
			// print result array
			String str = new String(result);
			System.out.println(str);
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			if(cArr[i] == 0) continue;
			
			result[count] = arr[i];
			cArr[i] -= 1;
			permute(arr, cArr, result, count + 1);
			cArr[i] += 1;
		}
	}
	
	
	public static void main(String[] args) {
		
		char[] arr = new char[]{'A', 'B', 'C'};
		int[] cArr = new int[]{2, 1, 1};
		char[] result = new char[4];
		
		Permutation obj = new Permutation();
		obj.permute(arr, cArr, result, 0);
	}
}
