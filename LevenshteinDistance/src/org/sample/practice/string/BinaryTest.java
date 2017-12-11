package org.sample.practice.string;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTest {

	@Test // test for base 2
	public void testBinary() {
		Binary obj = new Binary();

		// case 1
		obj = new Binary();
		obj.binary(1, 0, new int[1], 2);
		List<String> expected1 = new ArrayList<String>();
		expected1.add("0");expected1.add("1");
		assertEquals(expected1, obj.resultList);

		// case 2
		obj = new Binary();
		obj.binary(2, 0, new int[2], 2);
		List<String> expected2 = new ArrayList<String>();
		expected2.add("00");expected2.add("01");expected2.add("10");expected2.add("11");
		assertEquals(expected2, obj.resultList);

		// case 3
		obj = new Binary();
		obj.binary(3, 0, new int[3], 2);
		List<String> expected3 = new ArrayList<String>();
		expected3.add("000");expected3.add("001");expected3.add("010");expected3.add("011");
		expected3.add("100");expected3.add("101");expected3.add("110");expected3.add("111");
		assertEquals(expected3, obj.resultList);
		
		// case 4
		obj = new Binary();
		obj.binary(4, 0, new int[4], 2);
		List<String> expected4 = new ArrayList<String>();
		expected4.add("0000");expected4.add("0001");expected4.add("0010");expected4.add("0011");
		expected4.add("0100");expected4.add("0101");expected4.add("0110");expected4.add("0111");
		expected4.add("1000");expected4.add("1001");expected4.add("1010");expected4.add("1011");
		expected4.add("1100");expected4.add("1101");expected4.add("1110");expected4.add("1111");
		assertEquals(expected4, obj.resultList);
		
	}

	
	@Test // test for base 2
	public void testBinaryComb() {
		Binary obj = new Binary();

		// case 1
		obj = new Binary();
		obj.binaryComb(1, 0, new int[1], 2);
		List<String> expected1 = new ArrayList<String>();
		expected1.add("0");expected1.add("1");
		assertEquals(expected1, obj.resultList);

		// case 2
		obj = new Binary();
		obj.binaryComb(2, 0, new int[2], 2);
		List<String> expected2 = new ArrayList<String>();
		expected2.add("0");expected2.add("00");expected2.add("01");
		expected2.add("1");expected2.add("10");expected2.add("11");
		assertEquals(expected2, obj.resultList);

		// case 3
		obj = new Binary();
		obj.binaryComb(3, 0, new int[3], 2);
		List<String> expected3 = new ArrayList<String>();
		expected3.add("0");expected3.add("00");expected3.add("000");expected3.add("001");
		expected3.add("01");expected3.add("010");expected3.add("011");
		expected3.add("1");expected3.add("10");expected3.add("100");expected3.add("101");
		expected3.add("11");expected3.add("110");expected3.add("111");
		assertEquals(expected3, obj.resultList);
		
		// case 4
		obj = new Binary();
		obj.binaryComb(4, 0, new int[4], 2);
		List<String> expected4 = new ArrayList<String>();
		expected4.add("0");expected4.add("00");expected4.add("000");expected4.add("0000");
		expected4.add("0001");expected4.add("001");expected4.add("0010");expected4.add("0011");
		expected4.add("01");expected4.add("010");expected4.add("0100");
		expected4.add("0101");expected4.add("011");expected4.add("0110");expected4.add("0111");
		expected4.add("1");expected4.add("10");expected4.add("100");expected4.add("1000");
		expected4.add("1001");expected4.add("101");expected4.add("1010");expected4.add("1011");
		expected4.add("11");expected4.add("110");expected4.add("1100");
		expected4.add("1101");expected4.add("111");expected4.add("1110");expected4.add("1111");
		assertEquals(expected4, obj.resultList);
		
	}
	
	
	@Test // test for base 4
	public void testBinaryForBase4() {
		Binary obj = new Binary();

		// case 1
		obj = new Binary();
		obj.binary(1, 0, new int[1], 4);
		List<String> expected1 = new ArrayList<String>();
		expected1.add("0");expected1.add("1");
		expected1.add("2");expected1.add("3");
		assertEquals(expected1, obj.resultList);

		// case 2
		obj = new Binary();
		obj.binary(2, 0, new int[2], 4);
		List<String> expected2 = new ArrayList<String>();
		expected2.add("00");expected2.add("01");expected2.add("02");expected2.add("03");
		expected2.add("10");expected2.add("11");expected2.add("12");expected2.add("13");
		expected2.add("20");expected2.add("21");expected2.add("22");expected2.add("23");
		expected2.add("30");expected2.add("31");expected2.add("32");expected2.add("33");
		assertEquals(expected2, obj.resultList);

		// case 3
		/*obj = new Binary();
		obj.binary(3, 0, new int[3], 2);
		List<String> expected3 = new ArrayList<String>();
		expected3.add("000");expected3.add("001");expected3.add("010");expected3.add("011");
		expected3.add("100");expected3.add("101");expected3.add("110");expected3.add("111");
		assertEquals(expected3, obj.resultList);
		
		// case 4
		obj = new Binary();
		obj.binary(4, 0, new int[4], 2);
		List<String> expected4 = new ArrayList<String>();
		expected4.add("0000");expected4.add("0001");expected4.add("0010");expected4.add("0011");
		expected4.add("0100");expected4.add("0101");expected4.add("0110");expected4.add("0111");
		expected4.add("1000");expected4.add("1001");expected4.add("1010");expected4.add("1011");
		expected4.add("1100");expected4.add("1101");expected4.add("1110");expected4.add("1111");
		assertEquals(expected4, obj.resultList);*/
		
	}
}
