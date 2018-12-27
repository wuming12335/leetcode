package leetcode1_10;

import java.util.Arrays;

public class Leetcode04 {


	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double result;
		// 建立c数组，并将a添加进去
		int c[] = Arrays.copyOf(nums1, nums1.length+nums2.length);
		// 将b数组添加到已经含有a数组的c数组中去
		System.arraycopy(nums2, 0, c, nums1.length, nums2.length);
		// 对c数组进行排序
		Arrays.sort(c);
		
		if(c.length%2!=0) {
			result = c[c.length/2];
		}else {
			
			result = ((double)c[c.length/2]+(double)c[c.length/2-1])/2;
		}
		System.out.println("result="+result);
		return result;
	}
	
	public static void main(String[] args) {
		int nums1[] = new int[]{1, 2};
		int nums2[] = new int[]{3, 4};
		findMedianSortedArrays(nums1, nums2);
	}

}
