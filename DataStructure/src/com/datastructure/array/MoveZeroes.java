package com.datastructure.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 *Example:
 *Input: [0,1,0,3,12]
 *Output: [1,3,12,0,0]
 *You must do this in-place without making a copy of the array.
 *Minimize the total number of operations.
 */
public class MoveZeroes {

	 // Function which move all zeros to end of an array. 
	 public static void moveZeroes(int[] nums) {
        int count=0; // Count of non-zero elements
        
        // Traverse the array. If element encountered is 
        // non-zero, then replace the element at index 'count' 
        // with this element 
        for(int i=0 ;  i < nums.length; i++){
            if(nums[i] != 0){
                nums[count++]=nums[i]; //count is incremented
            }
         }
        // Now all non-zero elements have been shifted to 
        // front and 'count' is set as index of first 0. 
        // Make all elements 0 from count to end. 
        while(count < nums.length){
            nums[count++] = 0;
        }
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
		moveZeroes(nums); 
        System.out.println("Array after pushing zeros to the back: "+Arrays.toString(nums)); 
	}

}
