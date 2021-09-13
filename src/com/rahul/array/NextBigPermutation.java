/**
 * 
 */
package com.rahul.array;

import java.util.Arrays;

/**
 * @author rahul
 *
 *         31. Next Permutation Medium
 * 
 *         Implement next permutation, which rearranges numbers into the
 *         lexicographically next greater permutation of numbers.
 * 
 *         If such an arrangement is not possible, it must rearrange it as the
 *         lowest possible order (i.e., sorted in ascending order).
 * 
 *         The replacement must be in place and use only constant extra memory.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,2,3] Output: [1,3,2]
 * 
 *         Example 2:
 * 
 *         Input: nums = [3,2,1] Output: [1,2,3]
 * 
 *         Example 3:
 * 
 *         Input: nums = [1,1,5] Output: [1,5,1]
 * 
 *         Example 4:
 * 
 *         Input: nums = [1] Output: [1]
 * 
 * 
 * 
 *         Constraints:
 * 
 *         1 <= nums.length <= 100 0 <= nums[i] <= 100
 * 
 *         Accepted 586,612 Submissions 1,697,971
 */
public class NextBigPermutation {
	public static void main(String[] args) {
		int[] nums = {1,3,2};
		nextPermutation(nums);
		Arrays.stream(nums).forEach(System.out::println);
	}

	public static void nextPermutation(int[] nums) {
		int lastNo = -1;
		int indexToBeReplaced = -1;
		for (int j = nums.length - 1; j >= 0; j--) {
			
			for (int i = j-1; i >= 0; i--) {
				if (nums[i] < nums[j] && indexToBeReplaced<i) {
					indexToBeReplaced = i;
					lastNo = j;
					break;
				}
			}
			//if(indexToBeReplaced != -1) {
			//	break;
			//}
		}
		if (indexToBeReplaced == -1) {
			Arrays.sort(nums);
		} else {
			int tempNo = nums[lastNo] ;
			nums[lastNo] = nums[indexToBeReplaced];
			nums[indexToBeReplaced] = tempNo;
			int[] temp = new int[nums.length - indexToBeReplaced - 1];
			int j = 0;
			for (int i = indexToBeReplaced + 1; i < nums.length; i++) {
				temp[j++] = nums[i];
			}
			Arrays.sort(temp);
			j = 0;
			for (int i = indexToBeReplaced + 1; i < nums.length; i++) {
				nums[i] = temp[j++];
			}
		}

	}

}
