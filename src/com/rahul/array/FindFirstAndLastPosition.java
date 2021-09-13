package com.rahul.array;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array Medium
 * 
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 * 
 * Example 3:
 * 
 * Input: nums = [], target = 0 Output: [-1,-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105 -109 <= nums[i] <= 109 nums is a non-decreasing
 * array. -109 <= target <= 109
 * 
 * Accepted 819,377 Submissions 2,120,884 Seen this question in a real interview
 * before?
 * 
 * @author rahul
 *
 */
public class FindFirstAndLastPosition {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int[] res = searchRange(nums, 6);
		
		System.out.print("["+res[0]+","+res[1]+"]");
	}

	public static int[] searchRange(int[] nums, int target) {
		
		int first = getIndex(nums, target, true);
		int second = getIndex(nums, target, false);
		int[] res = new int[2];
		res[0] = first;
		res[1] = second;
return res;
	}
	
	private static int getIndex(int[] nums, int target, boolean isFirst) {
		int start = 0, end = nums.length - 1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(nums[mid] == target) {
				if(isFirst) {
					if(start == mid || nums[mid-1] != target) {
						return mid;
					}
					end = mid-1;
				}
				else {
					if(end == mid || nums[mid+1] != target) {
						return mid;
					}
					start = mid+1;
				}
			}else if(nums[mid]>target) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			
		}
		return -1;
	}

}
