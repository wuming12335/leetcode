package leetcode1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*/

public class Leetcode03 {
	public static int lengthOfLongestSubstring(String s) {
		
		List<String> list = new ArrayList<>();
		List<Object> numbers = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			for(int j=i+1,q=i;j<=s.length();j++,q++) {
				String c = s.substring(q, j);
				if(!list.contains(c)) {
					list.add(c);
				}else {
					numbers.add(list.size());
					list.clear();
					break;
				}
			}
		}
		numbers.add(list.size());
		System.out.println(numbers.size());
		int k=0;
		if(numbers.size()>0) {
			
			k = (int) numbers.get(0);
		}
		for(int i=0;i<numbers.size();i++) {
			
			if((int)numbers.get(i) > k) {
				k = (int) numbers.get(i);
			}
		}
		
		return k;
		
	}
	
	
	public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
            	//如果从i到j的字符串的没有重复，则最大不重复值为max(ans, j - i)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

	/**
	 * 判断当前字符串是否有重复的字符
	 * @param s
	 * @param start
	 * @param end
	 * @return
	 */
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    
    
    
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    
    public static int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        //循环整个字符串的每一个字符
        for (int j = 0, i = 0; j < n; j++) {
        	//判断字符是否在当前的map集合中
            if (map.containsKey(s.charAt(j))) {
            	//若字符存在集合之中，使得i为max(map.get(s.charAt(j)), i)
            	//i代表当前字符在前面重复出现的位置
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //当前不重复长度
            ans = Math.max(ans, j - i + 1);
            //map集合中存放的key为字符，value为字符的位置
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
/*
    Java（假设字符集为 ASCII 128）

    以前的我们都没有对字符串 s 所使用的字符集进行假设。

    当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。

    常用的表如下所示：

    int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
    int [128] 用于ASCII码
    int [256] 用于扩展ASCII码
    */
    
    public static int lengthOfLongestSubstring5(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
	
	public static void main(String[] args) {
//		String str = " ";
//		lengthOfLongestSubstring(str);
//		System.out.println("----------------");
//		String str1 = "bbbbb";
//		lengthOfLongestSubstring2(str1);
//		System.out.println("----------------");
		String str2 = "pwwkew";
		lengthOfLongestSubstring4(str2);
	}
}
