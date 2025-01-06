package com.infy.shufflearray;

// https://leetcode.com/problems/shuffle-the-array/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] numShuffled = new int[nums.length];
        int tracker = 0;
        for (int i = 0, j = nums.length/2; j < nums.length; i++, j++) {
            numShuffled[tracker] = nums[i];
            numShuffled[tracker+1] = nums[j];
            tracker += 2;
        }

        return numShuffled;
    }
}
