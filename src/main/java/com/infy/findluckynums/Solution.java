package com.infy.findluckynums;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/find-lucky-integer-in-an-array/
// done in one!
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i : arr) {
            int count = countMap.getOrDefault(i, 0);
            countMap.put(i, count+1);
        }

        int result = -1;
        for (int i : countMap.keySet()) {
            int s = countMap.get(i);
            if (s == i && i > result)
                result = i;
        }

        return result;
    }
}
