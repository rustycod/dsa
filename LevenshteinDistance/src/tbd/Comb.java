package tbd;

public class Comb {

	public static void comb(char[] charArray, int[] countArray, char[] result, int index, int depth, int k) {
		
		if(index == charArray.length || depth > k) {
			return;
		}
		
		// print array
		int currentIndex = depth;
		int currIndex = 0;
		while(currIndex < currentIndex) {
			System.out.print(result[currIndex]);
			currIndex++;
		}
		System.out.println();
		
		while(index < charArray.length) {
			
			if(countArray[index] == 0) {
				index++;
				continue;	
			}
			
			result[depth] = charArray[index];
			countArray[index]--;
			comb(charArray, countArray, result, index, depth + 1, k);
			countArray[index]++;
			
			index++;
		}
		
	}
	
	
	public static int combCount(int[] numArray, int start, int end, boolean len) {
		
		// base condition
		int length = end - start + 1;
				
		if(length == 0) {
			return 1;
		}
		
		int count1 = 0;
		int count2 = 0;
		if(length >= 1) {
			count1 = combCount(numArray, start + 1, end, true);
		} 
		
		if(length >= 2) {
			count2 = combCount(numArray, start + 2, end, false);
		} 
		
		return count1 + count2;
		
	}
	
	
	
	public static void combParenthesis(char[] charArray, int countLeft, int countRight, int count, int index) {
		
				
		if(countLeft > count && countRight > count) {
			// print charArray
			for(int i = 0; i < charArray.length; i++) {
				System.out.print(charArray[i]);
			}
			System.out.println();
			return;
		}
		
		if(countLeft <= count) {
			charArray[index] = '(';
			combParenthesis(charArray, countLeft + 1, countRight, count, index + 1);
		} 
		
		if(countRight <= count && countRight < countLeft) {
			charArray[index] = ')';
			combParenthesis(charArray, countLeft, countRight + 1, count, index + 1);
		} 
		
	}
	

	public static void main(String[] args) {
		/*char[] charArray = "ABCD".toCharArray();
		int[] countArray = {1,1,1,1};
		char[] result = new char[countArray.length];
		comb(charArray, countArray, result, 0, 0, 4);*/
		
		//int[] numArray = {1,2,3}; // combCount: 3
		//int[] numArray = {1,2,3,4}; // combCount: 5
		//int[] numArray = {1,2,3,4,5}; // combCount: 8
		//System.out.println("combCount: "+combCount(numArray, 0, numArray.length - 1, false));
		
		/*char[] charArray = new char[4];
		combParenthesis(charArray, 1, 1, 2, 0);*/
		
		/*char[] charArray = new char[6];
		combParenthesis(charArray, 1, 1, 3, 0);*/
		
		char[] charArray = new char[8];
		combParenthesis(charArray, 1, 1, 4, 0);
	}
		
}
