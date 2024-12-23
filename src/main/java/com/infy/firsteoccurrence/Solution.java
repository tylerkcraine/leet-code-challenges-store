package com.infy.firsteoccurrence;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int firstReoccurrence(int[] nums) {
        Integer minIndex = null;
        HashMap<Integer, Integer> repeatSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (repeatSet.containsKey(nums[i])) {
                if (minIndex == null || repeatSet.get(nums[i]) < minIndex) {
                    minIndex = repeatSet.get(nums[i]);
                }
            }
            repeatSet.put(nums[i], i);
        }
        
        return minIndex;
    }
}