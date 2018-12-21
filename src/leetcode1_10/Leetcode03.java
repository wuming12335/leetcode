package leetcode1_10;

import java.util.ArrayList;
import java.util.List;

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

	
	public static void main(String[] args) {
		String str = " ";
		lengthOfLongestSubstring(str);
//		System.out.println("----------------");
//		String str1 = "bbbbb";
//		lengthOfLongestSubstring(str1);
//		System.out.println("----------------");
//		String str2 = "pwwkew";
//		lengthOfLongestSubstring(str2);
	}
}
