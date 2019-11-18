package com.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber {
	
	//only for every element appears n times 
	public int singleNumber(int[] intArray) {
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
		return (int)Math.ceil((3*set_sum - array_sum)/(double)(3-1));
	}
	
	//only for every element appears twice 
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
	                        "occurrence is :" + singleNumber.singleNumber(a)); 
	     System.out.println("The element with single " +  
                 "occurrence is :" + singleNumber.singleNumberTwice(b));
	}

}
