package leetcode1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 26. 删除排序数组中的重复项 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2],
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

public class Leetcode26 {
	
	//第一种：自己的垃圾算法
	public static int removeDuplicates(int[] nums) {

		if(nums.length==0) {
			return 0;
		}
		
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int i:nums) {
			if(set.contains(i)) {
				continue;
			}else {
				set.add(i);
				list.add(i);
			}
		}
		for(int i=0;i<list.size();i++) {
			nums[i] = list.get(i);
		}
				
		return set.size();
	}
	
	//方法2：双指针//-3,-1,0,0,0,3,3
	public static int removeDuplicates2(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
	
	
	public static void main(String[] args) {
//		int[] nums = {0,0,1,1,1,2,2,3,3,4};
//		int[] nums2 = {1,1,2};
//		int n1 = removeDuplicates(nums);
//		System.out.println(n1);
//		int n2 = removeDuplicates(nums2);
//		System.out.println(n2);
		int[] nums3 = {-3,-1,0,0,0,3,3};
		int n3 = removeDuplicates2(nums3);
		Arrays.stream(nums3).forEachOrdered(System.out::println);
		System.out.println(n3);
	}
	
}
