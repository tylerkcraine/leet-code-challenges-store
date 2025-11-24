package com.infy.finished.largestavgsum;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }

        largestSumOfAveragesPrefix(prefix, k, -1);
        return 0;
    }

    public double largestSumOfAveragesPrefix(int[] prefixed, int k, int start) {
        if (k == 0)
            return 0;
        double max = 0.0;
        for (int j : prefixed) {
            double result = j + largestSumOfAveragesPrefix(prefixed, k - 1, start + 1);
            if (start != -1) result -= prefixed[start];

            if (result > max)
                max = result;
        }

        return max;
    }
}
