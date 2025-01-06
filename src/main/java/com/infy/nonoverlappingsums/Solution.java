package com.infy.nonoverlappingsums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// TODO finish
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int windowStart = 0;
        int windowEnd = 1;
        int tracker = 0;
        ArrayList<Integer> lengths = new ArrayList<>();

        int previousEnd = 0;

        while (windowEnd < arr.length+1) {
            int total = sumRange(arr, windowStart, windowEnd);
            System.out.print(Arrays.toString(Arrays.copyOfRange(arr,windowStart,windowEnd)));
            System.out.println(total);

            if (total < target)
                windowEnd++;
            else if (total == target) {
                int diff = (windowEnd - windowStart);
                if (!lengths.isEmpty() && previousEnd > windowStart && lengths.getLast() > diff) {
                    lengths.set(lengths.size()-1, diff);
                }

                previousEnd = windowEnd;
                tracker++;
                windowStart = tracker;
                windowEnd = tracker + 1;
            }
            else {
                tracker++;
                windowStart = tracker;
                windowEnd = tracker + 1;
            }
        }
        System.out.println(lengths);
        lengths.sort(Comparator.naturalOrder());

        if (lengths.size() < 2) {
            return -1;
        }

        System.out.println(lengths);
        return lengths.get(0) + lengths.get(1);
    }

    public int sumRange(int[] arr, int start, int end) {
        int total = 0;
        for (int i = start; i < end; i++) {
            total += arr[i];
        }
        return total;
    }
}
