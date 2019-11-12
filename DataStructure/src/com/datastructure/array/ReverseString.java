package com.datastructure.array;

/**
 * Write a function that reverses a string. The input string is given as an array of characters 
 * char[].Do not allocate extra space for another array, you must do this by modifying the 
 * input array in-place with O(1) extra memory.
 */
public class ReverseString {
	
	/**
	 * recursiveReverseString method reverses the char array using recursion
	 * Time complexity -> O(n) - since it has to loop to each element
	 * Space complexity -> O(n) due to recursion as it takes space to keep 
	 * track of the function calls
	 * @param s - input char array
	 * @param leftIndex - starting index
	 * @param rightIndex - ending index
	 * @return reversed char array
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
	 * reverseString method uses loop to reverse the given char array
	 * Time complexity -> O(n) - since it has to loop to each element
	 * Space complexity -> O(1)
	 * @param s - input char array
	 * @return reversed char array
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
