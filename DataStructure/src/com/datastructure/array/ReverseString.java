/**
 * 
 */
package com.datastructure.array;

import java.util.Arrays;

/**
 * @author Poovarasan
 *
 */
public class ReverseString {
	
	/**
	 * @param s
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public char[] recursiveReverseString(char[] s, int leftIndex, int rightIndex) {
	    if (leftIndex >= rightIndex) 
	    	return s;
	    char tmp = s[leftIndex];
	    s[leftIndex] = s[rightIndex];
	    s[rightIndex] = tmp;
	    return recursiveReverseString(s, ++leftIndex, --rightIndex);
	  }
	
	  /**
	 * @param s
	 * @return
	 */
	public char[] reverseString(char[] s) {
	    int leftIndex = 0, rightIndex= s.length-1;
	    char temp;
	    for(;leftIndex <= rightIndex; leftIndex++,rightIndex--) {
	    	temp = s[leftIndex];
	    	s[leftIndex] = s[rightIndex];
	    	s[rightIndex] = temp;
	    }
	    return s;
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] inputArray = {'H','E','L','L','O'};
		ReverseString reverseString = new ReverseString();
		char[] recursionResult = reverseString.recursiveReverseString(inputArray, 0, inputArray.length-1 );
		System.out.println("Recursion result");
		System.out.println(recursionResult);
		char[] iterationResult = reverseString.reverseString(inputArray);
		System.out.println("Iteration result");
		System.out.println(iterationResult);
	}

}
