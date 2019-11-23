package com.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a non-empty array of integers, every element appears n times except for one. Find that single one.
 *
 */
public class SingleNumber {
	
	/**
	 * This method returns the single element that appears one time only
	 * @param intArray - integer array
	 * @param n - number of times element appears except one element
	 * @return single element that appears one time only
	 */
	public int singleNumber(int[] intArray, int n) {
		int array_sum=0, set_sum=0;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i : intArray ) {
			hashSet.add(i);
		}
		set_sum =  hashSet.stream()
						  .reduce(0, Integer::sum);
		array_sum =Arrays.stream(intArray)
						 .reduce(0,Integer::sum);
		//(n times * sum of unique no's - sum of all no's)/(n times-1)
		return (int)Math.ceil((n*set_sum - array_sum)/(double)(n-1));
	}
	
	//only for every element appears twice 
	/**
	 * This is only for the pattern where each element appears twice except one
	 * This method returns the single element that appears one time only.
	 * @param nums - integer array
	 * @return single element that appears one time only
	 */
	public int singleNumberTwice(int[] nums) {
		int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[] = {12, 1, 12, 3, 12, 7, 1, 2, 3, 2, 2, 3, 1}; 
		 int b[] = {2,2,1};
		 SingleNumber singleNumber = new SingleNumber();
	     System.out.println("The element with single " +  
	                        "occurrence is :" + singleNumber.singleNumber(a, 3)); 
	     System.out.println("The element with single " +  
                 "occurrence is :" + singleNumber.singleNumberTwice(b));
	}

}
