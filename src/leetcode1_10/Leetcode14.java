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

	// 方法2：水平扫描法
	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	// 方法三3：水平扫描
	public static String longestCommonPrefix3(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	//方法4：分治
	public static String longestCommonPrefix4(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private static String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	static String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}
	
	//方法5：二分查找
	public static String longestCommonPrefix5(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);
	}

	private static boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}
	

	
	
	
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		// String[] strs = { "dog", "racecar", "car" };
		// String common = longestCommonPrefix(strs);
		String common = longestCommonPrefix5(strs);
		System.out.println(common);


	}

}
