package com.rahul.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 582. Kill Process Medium
 * 
 * You have n processes forming a rooted tree structure. You are given two
 * integer arrays pid and ppid, where pid[i] is the ID of the ith process and
 * ppid[i] is the ID of the ith process's parent process.
 * 
 * Each process has only one parent process but may have multiple children
 * processes. Only one process has ppid[i] = 0, which means this process has no
 * parent process (the root of the tree).
 * 
 * When a process is killed, all of its children processes will also be killed.
 * 
 * Given an integer kill representing the ID of a process you want to kill,
 * return a list of the IDs of the processes that will be killed. You may return
 * the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5 Output: [5,10]
 * Explanation: The processes colored in red are the processes that should be
 * killed.
 * 
 * Example 2:
 * 
 * Input: pid = [1], ppid = [0], kill = 1 Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * n == pid.length n == ppid.length 1 <= n <= 5 * 104 1 <= pid[i] <= 5 * 104 0
 * <= ppid[i] <= 5 * 104 Only one process has no parent. All the values of pid
 * are unique. kill is guaranteed to be in pid.
 * 
 * Accepted 53,801 Submissions 82,898
 * 
 * @author rahul
 *
 */

public class KillProcess {
	public static void main(String[] args) {
		KillProcess kp = new KillProcess();
		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(2);
		pid.add(3);
		pid.add(4);
		pid.add(5);
		List<Integer> ppid = new ArrayList<>();
		ppid.add(0);
		ppid.add(1);
		ppid.add(1);
		ppid.add(1);
		ppid.add(1);
		List<Integer> res = kp.killProcess(pid, ppid, 1);
		res.stream().forEach(System.out::println);

	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < ppid.size(); i++) {
			List<Integer> valueMap = map.getOrDefault(ppid.get(i), new ArrayList<>());
			valueMap.add(pid.get(i));
			map.put(ppid.get(i), valueMap);
		}
		res.add(kill);
		res.addAll(getMaped(map, kill, new HashSet<>()));
		return res;
	}

	private Set<Integer> getMaped(Map<Integer, List<Integer>> map, int kill, Set<Integer> res) {
		if (map.get(kill) == null || map.get(kill).isEmpty()) {
			return res;
		} else {
			for (Integer i : map.get(kill)) {
				res.add(i);
				getMaped(map, i, res);
			}
		}
		return res;
	}

}
