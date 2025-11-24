package com.infy.finished.sumoddpermutations;

import java.util.Arrays;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int windowSize = 1;
        int total = 0;
        while (windowSize <= arr.length) {
            total += slidingSum(arr, windowSize);
            windowSize += 2;
        }
        return total;
    }

    public int slidingSum(int[] arr, int size) {
        int total = 0;
        for (int windowStart = 0, windowEnd = size; windowEnd <= arr.length; windowStart++, windowEnd++) {
            for (int i = windowStart; i < windowEnd; i++) {
                total += arr[i];
            }
        }
        return total;
    }

    public int slidingSumStream(int[] arr, int size) {
        int windowStart = 0;
        int total = 0;
        while (Arrays.stream(arr).skip(windowStart).limit(size).count() == size) {
            total += Arrays.stream(arr).skip(windowStart).limit(size).sum();
        }
        return total;
    }
}
