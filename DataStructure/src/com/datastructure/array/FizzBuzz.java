package com.datastructure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for
 *  the multiples of five output “Buzz”. For numbers which are multiples of 
 *  both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
	
	/**
	 * NaviefizzBuzz method take n as input and generates a list of elements in the range of 1 to n,
	 * if element is divisible by 3 add "Fizz"
	 * if element is divisible by 5 add "Buzz"
	 * if element is divisible by 3 and 5 add "FizzBuzz"
	 * otherwise string representation of element.
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * @param n
	 * @return List<String>
	 */
	public List<String> NaviefizzBuzz(int n) {
        //create a list of n element
        List<String> arrayList = new ArrayList<String>(n);
        //loop through n elements
        for(int i=1; i <= n; i++){
        	boolean divisbleBy3 = (i % 3 == 0);
        	boolean divisbleBy5 = (i % 5 == 0);
        	// divisible by 3 and 5 
            if(divisbleBy5 && divisbleBy3){
                arrayList.add("FizzBuzz"); 
             // divisible by 5
            }else if(divisbleBy5){
                arrayList.add("Buzz");
             // divisible by 3 
            }else if(divisbleBy3){
                arrayList.add("Fizz");
             //Otherwise
            }else{
                arrayList.add(String.valueOf(i));
            }
        }
        return arrayList;
    }
	
	/**
	 * stringConcatfizzBuzz method take n as input and generates a list of elements in the range of 1 to n,
	 * if element is divisible by 3 add "Fizz"
	 * if element is divisible by 5 add "Buzz"
	 * if element is divisible by 3 and 5 add "FizzBuzz"
	 * otherwise string representation of element.
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * This method provides neater solution in case if 1 or 2 conditions increases 
	 * @param n
	 * @return List<String>
	 */
	public List<String> stringConcatfizzBuzz(int n) {
        //create a list of n element
        List<String> arrayList = new ArrayList<String>(n);
        //loop through n elements
        for(int i=1; i <= n; i++){
        	boolean divisbleBy3 = (i % 3 == 0);
        	boolean divisbleBy5 = (i % 5 == 0);
        	String numStr ="";
        	// divisible by 3 
            if(divisbleBy3){
            	numStr += "Fizz"; 
            }
            // divisible by 5
            if(divisbleBy5){
            	numStr += "Buzz";
            }
            //otherwise
            if(numStr.equals("")){
            	numStr +=String.valueOf(i);
            }
            arrayList.add(numStr);
        }
        return arrayList;
    }
	
	/**
	 * stringConcatfizzBuzz method take n as input and generates a list of elements in the range of 1 to n,
	 * if element is divisible by 3 add "Fizz"
	 * if element is divisible by 5 add "Buzz"
	 * if element is divisible by 3 and 5 add "FizzBuzz"
	 * otherwise string representation of element.
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * This method provides neater solution in case if there is too many conditions
	 * @param n
	 * @return List<String>
	 */
	public List<String> hashFizzBuzz(int n){
		//create a list of n element
        List<String> arrayList = new ArrayList<String>(n);
        //create hashmap to store all conditions
        HashMap<Integer,String> fizzBuzzMap = new HashMap<Integer, String>(){
        	{
        		put(3,"Fizz");
        		put(5,"Buzz");        	
        	}
        };
        //loop through n elements
        for(int i=1; i <= n; i++){
	         String numStr="";
	    	 for (Integer key : fizzBuzzMap.keySet()) {
	    		 // If the n is divisible by key,
	 	        // then add the corresponding string mapping to current numStr
	 	        if (i % key == 0) {
	 	        	numStr += fizzBuzzMap.get(key);
	 	        }
	    	 }
	    	 // If the n is not divisible by key,
	 	     // then add the string of i to current numStr
	    	 if(numStr.equals("")) {
	    		 numStr += String.valueOf(i);
	    	 }
	    	 arrayList.add(numStr);
        }
        return arrayList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FizzBuzz fizzBuzz= new FizzBuzz();
		List<String> navieAppResult = fizzBuzz.NaviefizzBuzz(17);
		System.out.println("Naive Approach result:" + navieAppResult);
		List<String> strAppResult = fizzBuzz.stringConcatfizzBuzz(17);
		System.out.println("StringConcat Approach result:" + strAppResult);
		List<String> hashAppResult = fizzBuzz.hashFizzBuzz(17);
		System.out.println("HashMap Approach result:" + hashAppResult);
	}

}
