package com.infy.nreoccurrence;

import java.util.HashMap;

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i,0)+1);
            if (countMap.get(i) == n)
                return i;
        }

        return -1;
    }
}
