package leetcode1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 14. 最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 */
public class Leetcode14 {

	// 方法一：自己的想法。
	public static String longestCommonPrefix(String[] strs) {
		// 1.若传进来的数组为空，直接返回"";
		if (strs.length < 1) {
			return "";
		}
		// 2.将字符数组转换成list集合
		List<String> list = Arrays.asList(strs);
		String common = "";
		Set<Character> set = new HashSet<Character>();
		// 3.获取整个数组中字符串最短的长度
		int minlength = list.get(0).length();
		for (int i = 1; i < list.size(); i++) {
			if (minlength > list.get(i).length()) {
				minlength = list.get(i).length();
			}
		}
		// 4.遍历最短次数
		for (int i = 0; i < minlength; i++) {
			for (int j = 0; j < list.size(); j++) {
				// 5.将每一个字符串的获取的字符放进set集合中
				set.add(list.get(j).charAt(i));
			}
			// 6.应为set集合是不能存放重复的字符，所以如果set的size大于1时，说明字符串的前缀已经不一样了
			if (set.size() > 1) {
				return common;
			} else {
				// 将set集合转换成list集合,方便获取值。
				List list2 = new ArrayList<>(set);
				// 将公共的字符串拼接起来
				common += list2.get(0);
				// 每一拼接后,将set清空，不影响下一次的操作。
				set.clear();
			}
		}
		System.out.println(common);
		return common;
	}
	
	
	

	public static void main(String[] args) {
		// String[] strs = { "flower", "flow", "flight" };
		String[] strs = { "dog", "racecar", "car" };
		String common = longestCommonPrefix(strs);
		System.out.println(common);

	}

}
