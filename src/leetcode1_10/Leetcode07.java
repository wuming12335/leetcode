package leetcode1_10;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为
 * [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class Leetcode07 {
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	// 49 ms
	public static int reverse2(int x) {
		if (x == 0)
			return 0;
		String str;
		String s = "";
		if (x > 0) {
			str = x + "";
		} else {
			str = ("" + x).substring(1);
		}
		Long max = 2147483647l;
		Long min = -2147483648l;
		for (int i = 0; i < str.length(); i++) {
			s = str.charAt(i) + s;
		}
		if (x < 0) {
			s = "-" + s;
		}

		Long l = Long.valueOf(s);
		if (l > max || l < min) {
			return 0;
		}
		return l.intValue();

	}
	
	public static int reverse3(int x) {
		StringBuffer sb = new StringBuffer();
		sb.append(x+"");
		sb.reverse();
		System.out.println(sb.toString());
		return 0;
	}

	public static void main(String[] args) {
		// max = 2147483647
		// min = -2147483648
		// System.out.println(Integer.MIN_VALUE);
		// int x = 1534236469;
		// System.out.println(reverse2(x));

		// int y = -2147483648;
		// System.out.println(reverse2(y));

//		int z = 0;
//		System.out.println(reverse2(z));

		int x = 1534236469;
		int y = -2147483648;
		System.out.println(reverse3(x));
		System.out.println(reverse3(y));
	}

}
