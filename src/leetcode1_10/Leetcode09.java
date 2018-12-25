package leetcode1_10;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
*/
public class Leetcode09 {

	/**
	 * 方法1：转换为字符串
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		}else {
			StringBuffer sb = new StringBuffer(x+"");
			StringBuffer str = new StringBuffer(x+"");
			sb.reverse();
			if((str.toString()).equals(sb.toString())) {
				return true;
			}
			return false;
		}
	}
	
	/**
	 * 方法2：不使用字符串，但此种方法可能造成溢出
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		} else {
			int rev = 0;
			int y = x;
			while(x>0) {
				int pop = x % 10;
				x = x /10;
//				if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
//					return 0;
//				if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
//					return 0;
				rev = rev*10+pop;
			}
			if(rev==y) {
				return true;
			}
			return false;
		}
	}
	
	/**
	 * 方法3
	 * @param x
	 * @return
	 */
	 public static boolean IsPalindrome3(int x) {
	        // 特殊情况：
	        // 如上所述，当 x < 0 时，x 不是回文数。
	        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
	        // 则其第一位数字也应该是 0
	        // 只有 0 满足这一属性
	        if(x < 0 || (x % 10 == 0 && x != 0)) {
	            return false;
	        }

	        int revertedNumber = 0;
	        while(x > revertedNumber) {
	            revertedNumber = revertedNumber * 10 + x % 10;
	            x /= 10;
	        }

	        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
	        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
	        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
	        return x == revertedNumber || x == revertedNumber/10;
	    }
	
	
	public static void main(String[] args) {
		int x = 1213;
		System.out.println(IsPalindrome3(x));
	}

}
