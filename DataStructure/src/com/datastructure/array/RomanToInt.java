package com.datastructure.array;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInt {
	
	public static int valueRomanInt(char letter) {
		if(letter == 'I') return 1;
		else if(letter == 'V') return 5;
		else if(letter == 'X') return 10;
		else if(letter == 'L') return 50;
		else if(letter == 'C') return 100;
		else if(letter == 'D') return 500;
		else if(letter == 'M') return 1000;
		return -1;
	}
	
	public static int romantoInt(String romanStr) {
		int result = 0;
		for(int i=0; i <   romanStr.length(); i++) {
			int currValue = valueRomanInt(romanStr.charAt(i));
			if (i+1 < romanStr.length()) {
				int nextValue = valueRomanInt(romanStr.charAt(i+1));
				if(currValue >= nextValue) {
					result += currValue;
				}else {
					result += nextValue-currValue;
					i++;
				}
			}else {
				result += currValue;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Integer for roman \"MCMIV\" is "+romantoInt("MCMIV"));
		System.out.println("Integer for roman \"I\" is "+romantoInt("I"));
		System.out.println("Integer for roman \"III\" is "+romantoInt("III"));
		System.out.println("Integer for roman \"IV\" is "+romantoInt("IV"));
		System.out.println("Integer for roman \"IX\" is "+romantoInt("IX"));
	}

}
