package com.infy.triangleSum;

import java.util.Arrays;

class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] newArray = new int[nums.length-1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (nums[i] + nums[i+1])%10;
        }
        System.out.println(Arrays.toString(newArray));
        return triangularSum(newArray);
    }
}
