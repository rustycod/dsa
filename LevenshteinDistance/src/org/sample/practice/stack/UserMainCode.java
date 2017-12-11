package org.sample.practice.stack;

import java.io.*;
import  java.util.*;

// Read only region start
public class UserMainCode
{

	public int CoveringTheManholes(int input1,int input2,int[][] input3){
		// Read only region end
		// Write code here...
		
		if(input1 < 0 || input2 < 0) {
			throw new UnsupportedOperationException("CoveringTheManholes(int input1,int input2,int[][] input3)");
		}
		
		if(input3 == null) {
			throw new UnsupportedOperationException("CoveringTheManholes(int input1,int input2,int[][] input3)");
		}
		
		System.out.println("length: "+input3.length);
		if(input1 != input3.length) {
			throw new UnsupportedOperationException("CoveringTheManholes(int input1,int input2,int[][] input3)");
		}
		
		for(int i = 0; i < input1; i++) {
			if(input2 != input3[i].length) {
				throw new UnsupportedOperationException("CoveringTheManholes(int input1,int input2,int[][] input3)");
			}
		}
		
		
		// count number of rows that have a manhole in it
		int rowCount = 0;
		for(int rowIndex = 0; rowIndex < input1; rowIndex++) {
			int sum = 0;
			for(int i = 0; i < input2; i++) {
				if(input3[rowIndex][i] != 0 && input3[rowIndex][i] != 1) {
					throw new UnsupportedOperationException("CoveringTheManholes(int input1,int input2,int[][] input3)");
				}
				sum += input3[rowIndex][i];
			}
			
			if(sum > 0) {
				rowCount++;
			}
		}
		
		System.out.println("rowCount: "+rowCount);
		if(rowCount == 0) {
			return 0; // no manholes exist
		}
		
		
		// count number of columns that have a manhole in it
		int columnCount = 0;
		for(int columnIndex = 0; columnIndex < input2; columnIndex++) {
			int sum = 0;
			for(int i = 0; i < input1; i++) {
				sum += input3[i][columnIndex];
			}
			
			if(sum > 0) {
				columnCount++;
			}		
		}
		
		System.out.println("columnCount: "+columnCount);
		
		if(rowCount < columnCount) {
			return rowCount;
		} else {
			return columnCount;
		}
	}
	
	public static void main(String[] args) {
		UserMainCode obj = new UserMainCode();
		
		int[][] mat = new int[4][4];
		mat[0] = new int[]{1, 0, 1, 0};
		mat[1] = new int[]{0, 1, 1, 1};
		mat[2] = new int[]{1, 1, 1, 0};
		mat[3] = new int[]{0, 0, 1, 0};
		
		System.out.println("first case: "+obj.CoveringTheManholes(4, 4, mat));
		
		int[][] mat2 = new int[4][4];
		mat2[0] = new int[]{0, 0, 0, 0};
		mat2[1] = new int[]{0, 0, 0, 0};
		mat2[2] = new int[]{0, 0, 0, 0};
		mat2[3] = new int[]{0, 0, 0, 0};
		
		System.out.println("second case: "+obj.CoveringTheManholes(4, 4, mat2));
		
		
		int[][] mat3 = new int[4][1];
		mat3[0] = new int[]{1};
		mat3[1] = new int[]{0};
		mat3[2] = new int[]{0};
		mat3[3] = new int[]{0};
		
		System.out.println("third case: "+obj.CoveringTheManholes(4, 1, mat3));

		int[][] mat4 = new int[1][4];
		mat4[0] = new int[]{1, 1, 1, 1};
		System.out.println("forth case: "+obj.CoveringTheManholes(1, 4, mat4));
		
		
		int[][] mat5 = new int[4][4];
		mat[0] = new int[]{1, 0, 1, 0};
		mat[1] = new int[]{0, 1, 1, 1};
		mat[2] = new int[]{1, 1, 1, 0};
		mat[3] = new int[]{0, 0, 1, 0};
		
		System.out.println("first case: "+obj.CoveringTheManholes(4, 4, mat));
		
	}
	
}