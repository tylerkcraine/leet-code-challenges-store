package com.infy.slidingwindowmedian;

import java.util.*;

class BadAgainSolution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> medianMap = new TreeMap<>();
        double[] medians = new double[nums.length-k+1];
        int firstInsertIndex = 0;
        int totalNums = 0;
        int double_i = 0;
        for (int i : nums) {
            if (totalNums >= k) {
                int removeCount = medianMap.get(nums[firstInsertIndex]);
                if (removeCount == 1)
                    medianMap.remove(nums[firstInsertIndex]);
                else
                    medianMap.put(nums[firstInsertIndex], removeCount-1);

                firstInsertIndex++;
                totalNums--;
            }

            int count = medianMap.getOrDefault(i,0);
            medianMap.put(i, count+1);
            if (totalNums == k-1) {
                medians[double_i] = parseMedian(medianMap,k);
                double_i++;
            }
            totalNums++;
        }
        return medians;
    }

    public double parseMedian(TreeMap<Integer,Integer> medianMap, int k) {
        int total = 1;
        int targetOne = k / 2 + 1;
        Integer targetTwo = null;
        if (k % 2 == 0) {
            targetOne = k/2;
            targetTwo = targetOne + 1;
        }
        long sum = 0;
        boolean found = false;
        for (int i : medianMap.keySet()) {
            int count = medianMap.get(i);
            if (found)
                break;
            for (int p = 0; p < count; p++) {
                if (total == targetOne) {
                    sum += i;
                    if (k % 2 != 0) {
                        found = true;
                        break;
                    }
                }
                if (targetTwo != null && total == targetTwo) {
                    sum += i;
                    found = true;
                    break;
                }
                total++;
            }
        }
        if (k % 2 == 0)
            return sum / 2.0;
        else
            return sum;
    }
}
