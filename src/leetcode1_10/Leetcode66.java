package leetcode1_10;

import java.awt.datatransfer.SystemFlavorMap;
import java.lang.reflect.Array;
import java.util.Arrays;

//66. 加一
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/

public class Leetcode66 {
	
	
	public static int[] plusOne(int[] digits) {
		if(digits.length==0) return new int[] {1};
		//如果最后一位不是9，直接+1返回
		if(digits[digits.length-1]!=9) {
			digits[digits.length-1] = digits[digits.length-1]+1;
		}else {
			//如果最后一位是9，则需要判断前面的几位
			//1.获取前几位的数组
			int[] plus = Arrays.copyOf(digits, digits.length-1);
			//2.进行递归
			plus = plusOne(plus);
			//3.在最后补个0
			plus = Arrays.copyOf(plus, plus.length+1);
			return plus;
		}
		return digits;
    }
	
	public static void main(String[] args) {
		int[] digits = new int[]{9,9,9};
		int[] result = plusOne(digits);
		System.out.println(result);
	}
}
