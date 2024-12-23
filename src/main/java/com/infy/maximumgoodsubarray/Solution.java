package com.infy.maximumgoodsubarray;

import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Long max = null;
        long[] prefix = new long[nums.length];
        ArrayList<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            //calculate the prefix sum for this index
            if (i == 0)
                prefix[i] = nums[i];
            else
                prefix[i] = prefix[i-1] + nums[i];

            Integer indexList = indexMap.getOrDefault(nums[i], null);
            if (indexList == null || prefix[indexList] > prefix[i])
                indexMap.put(nums[i], i);
            int xOne = nums[i] + k;
            int xTwo = nums[i] - k;

            if (indexMap.containsKey(xOne))
                results.add(indexMap.get(xOne));

            if (indexMap.containsKey(xTwo))
                results.add(indexMap.get(xTwo));

            for (Integer y : results) {
                long sum;
                if (y == 0)
                    sum = prefix[i];
                else
                    sum = prefix[i] - prefix[y-1];
                if (max == null || sum > max)
                    max = sum;
            }
            results.clear();
        }

        return Objects.requireNonNullElse(max, 0L);
    }
}
