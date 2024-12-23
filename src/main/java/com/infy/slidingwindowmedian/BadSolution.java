package com.infy.slidingwindowmedian;

import java.util.ArrayList;
import java.util.Arrays;

class BadSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int windowStart = 0;
        if (k == 1) {
            return Arrays.stream(nums).mapToDouble(a -> (double) a).toArray();
        } if (nums.length == 2 && k == 2) {
            return new double[] {((double) nums[0] + (double) nums[1]) / 2};
        }

        int skip;
        int limit;
        if (k % 2 == 0) {
            skip = (k/2)-1;
            limit = 2;
        } else {
            skip = (k/2);
            limit = 1;
        }

        ArrayList<Double> medians = new ArrayList<>();
        while (windowStart <= nums.length-k) {
            double[] window = Arrays.stream(nums)
                    .mapToDouble(a -> a)
                    .skip(windowStart)
                    .limit(k)
                    .sorted()
                    .skip(skip)
                    .limit(limit)
                    .toArray();
            System.out.println(Arrays.toString(window));
            if (k % 2 == 0) {
                medians.add((window[0]+window[1])/2);
            } else {
                medians.add(window[0]);
            }
            windowStart++;
        }

        return medians.stream().mapToDouble(a -> a).toArray();
    }
}


