package tiago;

import java.io.File;

public class Solution {

	public int maxResult(String number) {
		char[] digits = number.toCharArray();
		int max_result = Integer.MIN_VALUE;
		int current = 1;
		int count = 0;
		boolean filling = true;
		for(int i = 0; i < digits.length; i++) {
			if(!filling) {
				int denominator = asInt(digits[i-5]);
				int numerator = asInt(digits[i]);
				if(numerator == 0) {
					current = 1;
					filling = true;
					continue;
				}
				current = current*numerator/denominator;
				if(current > max_result) {
					max_result = current;
				}
			}
			else {
				if(++count == 5) {
					filling = false;
					count = 0;
				}
				current = current*asInt(digits[i]);
				if(current == 0) {
					current = 1;
					count = 0;
					filling = true;
				}
			}
			
		}
		return max_result;
	}
	
	private int asInt(char digit) {
		return new Integer(String.valueOf(digit));
	}
	
	public static void main(String[] args) {
		Reader reader = new Reader(new File("number.txt"));
		String number = reader.load();
		int result = new Solution().maxResult(number);
		System.out.println("\nMaior produto: " + result);
	}
	
}
