package com.rahul.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 39. Combination Sum Medium
 * 
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times. 7 is a candidate, and 7 = 7. These are the only two combinations.
 * 
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Example 3:
 * 
 * Input: candidates = [2], target = 1 Output: []
 * 
 * Example 4:
 * 
 * Input: candidates = [1], target = 1 Output: [[1]]
 * 
 * Example 5:
 * 
 * Input: candidates = [1], target = 2 Output: [[1,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 30 1 <= candidates[i] <= 200 All elements of
 * candidates are distinct. 1 <= target <= 500
 * 
 * Accepted 827,852 Submissions 1,337,918
 * 
 * @author rahul
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] arr = { 2 };
		List<List<Integer>> res = c.combinationSum(arr, 1);

		res.stream().forEach(System.out::println);

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<Integer> set = new HashSet<>();
		Arrays.stream(candidates).forEach(p -> {
			set.add(p);
		});
		List<Integer> nums = new ArrayList<>(set);
		Collections.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		combinnedSum(nums, target, new ArrayList<>(), res, 0);
		return res;

	}

	public void combinnedSum(List<Integer> arr, int target, List<Integer> temp, List<List<Integer>> res,
			int leftIndex) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
		} else if (target > 0) {
			for (Integer num : arr) {
				if (target >= num && num >= leftIndex) {
					temp.add(num);
					combinnedSum(arr, target - num, temp, res, num);
					temp.remove(num);
				}
			}
		}
	}

}
