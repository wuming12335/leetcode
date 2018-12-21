package leetcode1_10;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

public class Leetcode01 {
	
	static int nums[] = {2,7,11,15};
	
	/**
	 * 第一种方法，去两个数之和与目标值进行对比，若相等则去两个值的下标索引
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums,int target) {
		
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	/**
	 * 使用map进行存放，将值作为key，下标作为value存放进map之中，然后遍历数组，使用  需要查找值=(目标值-遍历的值)，判断此结果是否在map之中，
	 * 若在，则返回遍历时的下标i，map.get(target-nums[i])。
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums,int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i],i);
		}
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target-nums[i])) {
//				System.out.println(i+"-----"+map.get(target-nums[i]));
				return new int[]{i,map.get(target-nums[i])};
			}
		}
		
		return null;
		
	}
	
	/**
	 * 创建一个map，首先使用map中是否存在(target-nums[i]),若不存在则将此nums[i]作为key,i作为value放入map中，
	 * 若存在，则i,map.get(target-nums[i])即为所求值。
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				
				return new int[] {i,map.get(target-nums[i])};
			}else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		int[] result = Leetcode01.twoSum(nums, 9);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
