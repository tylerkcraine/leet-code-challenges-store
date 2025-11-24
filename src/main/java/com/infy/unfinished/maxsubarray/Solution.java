package com.infy.unfinished.maxsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public int[] maxAndMinSum(int[] nums) {
        int total = 0;
        Integer max = null;
        Integer min = null;
        for (int num : nums) {
            total += num;
            if (max == null || max < total)
                max = total;
            if (min == null || min > total)
                min = total;
        }
        return new int[]{min, max};
    }

    public int maxAbsoluteSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] prefix = maxAndMinSum(nums);
        System.out.println(Arrays.toString(prefix));
        int min = prefix[0];
        int max = prefix[1];

        return Stream.of(max-min, min-max, max, min).map(Math::abs).max(Integer::compareTo).get();
    }
}
