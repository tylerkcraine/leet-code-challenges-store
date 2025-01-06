package com.infy.longestsubarrayafterdelete;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
class Solution {

    // variable to store the last right value calculation to save on processing time
    private Integer lastRight;

    public int longestSubarray(int[] nums) {
        lastRight = null;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            // using the zeros as pivot points
            if (nums[i] == 0) {
                int count = expand(nums, i);
                if (count > max)
                    max = count;
            }
        }

        // base case if zero not found
        if (max == -1) {
            return nums.length-1;
        } else {
            return max;
        }
    }

    public int expand(int[] nums, int index) {
        int total = 0;

        int right = index + 1;
        while (right < nums.length && nums[right] != 0) {
            total++;
            right++;
        }

        if (lastRight != null)  {
            int temp = lastRight;
            lastRight = total;
            return total + temp;
        }

        // should only be run once at the start of the program
        int left = index - 1;
        while (left >= 0 && nums[left] != 0) {
            total++;
            left--;
        }
        return total;
    }
}
