package org.sample.practice.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StackConversion {

	private static Map<Character, Integer> preferenceMap;
	private static Stack<Character> stack = new Stack<Character>();
	
	// checking balancing of following symbols
	private static Set<Character> symbols;
	
	static {
		preferenceMap = new HashMap<Character, Integer>();
		preferenceMap.put('+', 12);
		preferenceMap.put('-', 12);
		preferenceMap.put('*', 13);
		preferenceMap.put('/', 13);
		preferenceMap.put('%', 13);
		preferenceMap.put('(', 17);
		preferenceMap.put(')', 17);
		
		
		symbols = new HashSet<Character>();
		symbols.add('(');
		symbols.add(')');
		symbols.add('{');
		symbols.add('}');
		symbols.add('[');
		symbols.add(']');
		
	}
	
	public static String infixTopostfix(String infix) {

		char[] infixCharArray = infix.toCharArray();
		List<Character> postfix = new ArrayList<Character>();
		
		for(int i = 0; i < infixCharArray.length; i++) {
			char inChar = infixCharArray[i];
			
			// rules
			if(!preferenceMap.containsKey(inChar)) { // inChar is operand
				postfix.add(inChar);
			} else if(inChar == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '('){
						stack.pop();
						break;
					} else {
						postfix.add(stack.pop());
					}
				}
			} else {
				
				while(!stack.isEmpty()) {
					
					if(preferenceMap.get(stack.peek()) >= preferenceMap.get(inChar) && stack.peek() != '(') {
						postfix.add(stack.pop());
					} else {
						break;
					}
				}
				
					stack.push(inChar);
				
			} // end of rules
		} // end of for loop
		
		
		// empty the stack
		while(!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		
		
		// convert list of chars to string
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < postfix.size(); i++) {
			sb.append(postfix.get(i));
		}
		
		return sb.toString();
	}
	
	
	public static boolean areSymbolsBalanced(String inExpression) {

		Stack<Character> stack = new Stack<Character>();
		
		char[] charArray = inExpression.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if(symbols.contains(c)) {
				
				if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						return false;
					} 
					stack.pop();
				} else if(c == '}') {
					if(stack.isEmpty() || stack.peek() != '{') {
						return false;
					} 
					stack.pop();				
				} else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						return false;
					} 
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}
}
