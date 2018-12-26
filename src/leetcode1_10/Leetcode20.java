package leetcode1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
*/

public class Leetcode20 {
	public static boolean isValid(String s) {

		List<String> list = new ArrayList<>();
		int q = 0;
		for (int i = 0, j = i + 1; j <= s.length(); i++, j++) {
			String c = s.substring(i, j);
			if (list.size() == 0) {
				list.add(c);
				q++;
			} else {
				if (c.equals("{")) {
					if (list.get(q - 1).equals("}")) {
						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				} else if (c.equals("}")) {
					if (list.get(q - 1).equals("{")) {

						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				} else if (c.equals("[")) {
					if (list.get(q - 1).equals("]")) {

						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				} else if (c.equals("]")) {
					if (list.get(q - 1).equals("[")) {

						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				} else if (c.equals("(")) {
					if (list.get(q - 1).equals(")")) {

						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				} else if (c.equals(")")) {
					if (list.get(q - 1).equals("(")) {

						list.remove(q - 1);
						q--;
					} else {
						list.add(c);
						q++;
					}
				}

			}
		}

		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		String s = "([)";
//		System.out.println(isValid(s));
		
		Solution solution = new Solution();
		solution.isValid("([)");
	}
}



class Solution {

	  // Hash table that takes care of the mappings.
	  private HashMap<Character, Character> mappings;

	  // Initialize hash map with mappings. This simply makes the code easier to read.
	  public Solution() {
	    this.mappings = new HashMap<Character, Character>();
	    this.mappings.put(')', '(');
	    this.mappings.put('}', '{');
	    this.mappings.put(']', '[');
	  }

	  public boolean isValid(String s) {

	    // Initialize a stack to be used in the algorithm.
	    Stack<Character> stack = new Stack<Character>();

	    for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);

	      // If the current character is a closing bracket.
	      if (this.mappings.containsKey(c)) {

	        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
	        char topElement = stack.empty() ? '#' : stack.pop();

	        // If the mapping for this bracket doesn't match the stack's top element, return false.
	        if (topElement != this.mappings.get(c)) {
	          return false;
	        }
	      } else {
	        // If it was an opening bracket, push to the stack.
	        stack.push(c);
	      }
	    }

	    // If the stack still contains elements, then it is an invalid expression.
	    return stack.isEmpty();
	  }
	}
