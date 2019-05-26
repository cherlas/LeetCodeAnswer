package cn.istarx.java;

/*
class ListNode:
#     def __init__(self, x):
#         self.val = ximport java.util.*;
*/

import java.util.HashMap;
import java.util.Map;

class NO1_TwoSum {
	public static void main(String[] args) {
		System.out.println();
	}

	private int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> tmp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int rest = target - nums[i];
			if (tmp.containsKey(rest)) {
				return new int[] {tmp.get(rest), i};
			} else {
				tmp.put(rest, i);
			}
		}
		return new int[2];
	}
}