package com.infy.evenoddpairs;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        IntStream negatives = Arrays.stream(nums).filter((a) -> a < 0);
        IntStream positives = Arrays.stream(nums).filter((a) -> a > 0);

        int[] result = new int[nums.length];
        final int[] neg_start = {1};
        final int[] pos_start = {0};
        negatives.forEach((a) -> {
            result[neg_start[0]] = a;
            neg_start[0] += 2;
        });

        positives.forEach((a) -> {
            result[pos_start[0]] = a;
            pos_start[0] += 2;
        });

        return result;
    }
}
