package org.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Combination {/*

   public void combination(char input[]){
       Map<Character, Integer> countMap = new TreeMap<Character, Integer>();
       countMap.put('A', 2);
       countMap.put('B', 1);
       countMap.put('C', 1);
       for (char ch : input) {
           countMap.compute(ch, (key, val) -> {
               if (val == null) {
                   return 1;
               } else {
                   return val + 1;
               }
           });
       }
       char str[] = new char[3];
       int count[] = new int[3];
       int index = 0;
       for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
           str[index] = entry.getKey();
           count[index] = entry.getValue();
           index++;
       }
       char[] output = new char[input.length];
       combination(str, count, 0, output, 0);
    }

    private void combination(char input[],int count[],int pos, char output[],int len){
        print(output, len);
        for(int i=pos; i < input.length; i++){
            if (count[i] == 0) {
                continue;
            }
            output[len] = input[i];
            count[i]--;
            combination(input, count, i, output, len + 1);
            count[i]++;
        }
    }

    private void print(char result[],int pos){
        for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public void combinationEasy(char[] input) {
        List<Character> r = new ArrayList<Character>();
        Arrays.sort(input);
        combinationEasy(input, 0, r);
    }

    private void combinationEasy(char[] input, int pos, List<Character> r) {

        //r.forEach(r1 -> System.out.print(r1 + " "));
        System.out.println();
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i-1]) {
                continue;
            }
            r.add(input[i]);
            combinationEasy(input, i + 1, r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String args[]){
        Combination c = new Combination();
        c.combination("aabbc".toCharArray());
        //c.combinationEasy("aabbc".toCharArray());

    }*/
 
	public static void combination(char[] str, int[] count, int level, int currentPosition, char[] result){
		
		printArray(result, level);
		
		for(int i=currentPosition; i < str.length; i++) {
			
			if(count[i] == 0) {
				//currentPosition++;
				continue;
			}
			
			count[i]--;
			result[level] = str[i];
			combination(str, count, level + 1, i, result);
			count[i]++;
			
		}
		
	}
	
	
	public static void main (String[] args) {
		/*char[] str = new char[]{'A','B','C'};
		int[] count = new int[]{2,1,1};
		char[] result = new char[4];*/
		
		char[] str = new char[]{'A','B','B','D','E'};
		int[] count = new int[]{1,1,1,1,1};
		char[] result = new char[5];
		
		
		combination(str, count, 0, 0, result);
	} 
	
	public static void printArray(char[] result, int length) {
		for(int i = 0; i < length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
}