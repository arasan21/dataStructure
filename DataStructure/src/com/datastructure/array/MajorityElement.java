package com.datastructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 
 *
 */
public class MajorityElement {
	
	/**
	 * Time complexity : O(n^2)
	 * Space complexity : O(1)
	 * @param numArray
	 * @return
	 */
	public static int naiveMajorityElement(int[] numArray) {
		int majorityCount = numArray.length/2;
		for(int i : numArray) {
			int count = 0;
			for(int elem : numArray) {
				if(i == elem) count++;
			}
			if(count > majorityCount) return i;
		}
		return -1;
	}
	
	/**
	 * Time complexity : O(n)
	 * Space complexity : O(n)
	 * @param numArray
	 * @return
	 */
	public static int heapMajorityElement(int[] numArray) {
		int majorityCount = numArray.length/2;
		HashMap<Integer,Integer> countHashMap = countNums(numArray);
		int majorityElem = countHashMap.entrySet().stream()
								.filter(k -> k.getValue() > majorityCount)
								.map(Map.Entry::getKey)
								.findFirst().get();
		return majorityElem;
	}

	/**
	 * @param numArray
	 */
	private static HashMap<Integer, Integer> countNums(int[] numArray) {
		HashMap<Integer,Integer> countHashMap = new HashMap<Integer, Integer>();
		for(int i : numArray) {
			if(!countHashMap.containsKey(i)) countHashMap.put(i, 1);
			else countHashMap.put(i, countHashMap.get(i)+1);
		}
		return countHashMap;
	}
	
	/**
	 * Time complexity : O(nlgn)
	 * Space complexity : O(1)
	 * @param numArray
	 * @return
	 */
	public static int inbuiltMajorityElement(int[] numArray) {
		Arrays.sort(numArray);
		return numArray[numArray.length/2];
	}

	public static void main(String[] args) {
		int[] numArray = {2,2,1,1,1,2,2};
		//for naiveMajorityElement approach
		long startTime = System.nanoTime();
		System.out.println("naiveMajorityElement : "+naiveMajorityElement(numArray));
		long stopTime = System.nanoTime();
        System.out.println("Time taken for naiveMajorityElement in milliseconds: "
        					+TimeUnit.SECONDS.convert(( stopTime - startTime), TimeUnit.MILLISECONDS)
        					+" ms");
        //for heapMajorityElement approach
        startTime = System.nanoTime();
        System.out.println("naiveMajorityElement : "+heapMajorityElement(numArray));
		stopTime = System.nanoTime();
        System.out.println("Time taken for heapMajorityElement in milliseconds: "
        					+TimeUnit.SECONDS.convert(( stopTime - startTime), TimeUnit.MILLISECONDS)
        					+" ms");
        //for inbuiltMajorityElement approach
        startTime = System.nanoTime();
        System.out.println("naiveMajorityElement : "+inbuiltMajorityElement(numArray));
		stopTime = System.nanoTime();
        System.out.println("Time taken for inbuiltMajorityElement in milliseconds: "
        					+TimeUnit.SECONDS.convert(( stopTime - startTime), TimeUnit.MILLISECONDS)
        					+" ms");
	     
	}

}
