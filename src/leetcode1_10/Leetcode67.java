package leetcode1_10;

import java.math.BigInteger;

//67. 二进制求和
/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"  
输出: "10101"
*/

public class Leetcode67 {
	public static String addBinary(String a, String b) {
//		String sum = "";
//		int i,j;
//		for(i=a.length()-1,j=b.length()-1;i>=0&&j>=0;i--,j--) {
//			sum = Integer.parseInt(String.valueOf(a.charAt(i)))+Integer.parseInt(String.valueOf(b.charAt(j)))+sum;
//		}
//		if(i>=0) {
//			sum = a.substring(0, i+1)+sum;
//		}
//		if(j>=0) {
//			sum = b.substring(0, j+1)+sum;
//		}
//		
//		if(sum.equals("0")) return "0";
//		if(sum.equals("1")) return "1";
//		if(sum.equals("2")) return "10";
//		
//		String[] str = sum.split("");
//		Long[] sm = new Long[str.length];
//		for(i=0;i<str.length;i++) {
//			sm[i] = Long.parseLong(str[i]);
//		}
//		for(i=sm.length-1;i>=0;i--) {
//			if(sm[i]>1) {
//				sm[i] = sm[i]-2;
//				if(i-1>=0) {
//					sm[i-1] = sm[i-1]+1;
//				}
//			}
//		}
//		
//		StringBuffer sb = new StringBuffer();
//		for(i=0;i<sm.length;i++) {
//			sb.append(sm[i]);
//		}
//		
//		return sb.toString();

		return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
		
	}
	
	public static void main(String[] args) {
		String a = "1";
		String b = "111";
		
		
		
		String result = addBinary(a, b);
		System.out.println(result);
		
	}
}
