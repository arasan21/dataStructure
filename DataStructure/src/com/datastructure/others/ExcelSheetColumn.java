package com.datastructure.others;


/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 *
 */
public class ExcelSheetColumn {
	
	
	/**
	 * This method gets Excel Sheet Column in string and converts it in to number
	 * @param ExcelSheetColumn in string
	 * @return ExcelSheetColumn in number
	 */
	public static int titleToNumber(String s) {                                           
		int result = 0; 
		for(int i=0; i < s.length(); i++) {
			result *= 26;
			result += s.charAt(i) - 'A' +1 ;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("titleToNumber for A : "+titleToNumber("A"));
		System.out.println("titleToNumber for AA : "+titleToNumber("AA"));
		System.out.print("titleToNumber for CDA : "+titleToNumber("CDA"));
	}

}
