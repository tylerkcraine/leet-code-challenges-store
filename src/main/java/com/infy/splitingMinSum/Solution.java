package com.infy.splitingMinSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minimumSum(int num) {
        String splitString = Integer.toString(num);
        String[] stringArr = splitString.split("");
        int result = calcMin(Arrays.stream(stringArr).toList());
        return result;
    }

    public int calcMin(List<String> arr) {
        Integer min = null;

        int windowSize = 1;
        while (windowSize < arr.size()) {
            int offset = 0;
            while (offset+windowSize-1 < arr.size()) {
                ArrayList<String> sides = new ArrayList<>();
                sides.addAll(arr.subList(0, offset));
                sides.addAll(arr.subList(offset+windowSize, arr.size()));

                int left = findMinNum(sides);
                int right = findMinNum(arr.subList(offset,offset+windowSize));
                if (min == null || min > left+right)
                    min = left+right;
                offset++;
            }
            windowSize++;
        }
        return min;
    }

    public int findMinNum(List<String> nums) {
        PriorityQueue<String> lowerQueue = new PriorityQueue<>(nums);
        StringBuilder result = new StringBuilder();
        while (!lowerQueue.isEmpty()) {
            result.append(lowerQueue.poll());
        }
        return Integer.parseInt(result.toString());
    }
}

