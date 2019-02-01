package leetcode1_10;

import java.util.HashMap;
import java.util.Map;

/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
*/

public class Leetcode13 {

	/*
	 * 解法：从左到右进行判断,如果左边大于右边就左边+右边,如果左边小于右边就右边减去左边。
	 * 但是由于中间的数都会进行两次操作,所以需要在加减完成后减去中间的数。
	 */
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		
		int num=0;
		for(int i=0;i<s.length()-1;i++) {
			char a = s.charAt(i);
			char b = s.charAt(i+1);
			
			if(map.get(a)>=map.get(b)) {
				num+=(map.get(a)+map.get(b));
				num-=map.get(b);
			}else {
				num+=(map.get(b)-map.get(a));
				num-=map.get(b);
			}
		}
		num += map.get(s.charAt(s.length()-1));
		return num;
	}
	public static void main(String[] args) {
		String s = "III";
		int romanToInt = romanToInt(s);
		System.out.println(romanToInt);
	}

}
