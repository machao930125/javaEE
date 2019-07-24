package com.chao.list;

import java.util.HashMap;

class Solution {

	public static int lengthOfLongestSubstring(String s) {

		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		int j = 0;

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(map.get(s.charAt(i)), j);
			}
			count = Math.max(count, i - j + 1);
			map.put(s.charAt(i), i + 1);
		}
		return count;

	}

	public static void main(String[] args) {
		String s = "aabaab!bb";
//		String s = "dvdf";
//		String s = " ";
//		String s = "cdd";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}
}