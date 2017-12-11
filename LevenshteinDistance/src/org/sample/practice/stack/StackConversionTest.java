package org.sample.practice.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackConversionTest {

	
	@Test
	public void testInfixTopostfix() {
		
		assertEquals("AB+", StackConversion.infixTopostfix("A+B"));
		assertEquals("ABC*+", StackConversion.infixTopostfix("A+B*C"));
		assertEquals("AB*C/", StackConversion.infixTopostfix("A*B/C"));
		assertEquals("AB*C+", StackConversion.infixTopostfix("A*B+C"));
		assertEquals("AB*CD+-E+", StackConversion.infixTopostfix("A*B-(C+D)+E"));
		assertEquals("AB+CD+*", StackConversion.infixTopostfix("(A+B)*(C+D)"));
		assertEquals("AB+CD+*EF-/", StackConversion.infixTopostfix("(A+B)*(C+D)/(E-F)"));
	}
	
	@Test
	public void testAreSymbolsBalanced() {
		
		assertTrue(StackConversion.areSymbolsBalanced("(A+B)+(C-D)"));
		assertTrue(!StackConversion.areSymbolsBalanced("((A+B)+(C-D)"));
		assertTrue(StackConversion.areSymbolsBalanced("((A+B)+[C-D])"));
		assertTrue(!StackConversion.areSymbolsBalanced("((A+B)+[C-D]}"));
		assertTrue(!StackConversion.areSymbolsBalanced(")A+B)"));
	}

}
