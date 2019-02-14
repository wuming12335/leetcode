package leetcode1_10;

//38.报数
/*
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
*/
public class Leetcode38 {
	//方法思路：输入n的时候,如果是1则直接返回,但是如果n>1,则需要先求出(n-1)序列的字符串，采用递归方法
	public static String countAndSay(int n) {
		if(n==1) {
			return "1";
		}
		String s = countAndSay(n-1);
		char c = s.charAt(0);
		String result = "";
		int j=1;
		for(int i = 1; i<s.length(); i++) {
			if(c==s.charAt(i)) {
				j++;
			}else {
				result =result+ j+""+c+"";
				c = s.charAt(i);
				j=1;
			}
		}
		result =result+j+""+s.charAt(s.length()-1)+"";
		return result;
	}
	
	
	public static void main(String[] args) {
			String result = countAndSay(20);
			System.out.println(result);
	}
}
