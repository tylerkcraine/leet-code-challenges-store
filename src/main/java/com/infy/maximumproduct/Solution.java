package com.infy.maximumproduct;


// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return ((nums[nums.length-1]-1) * (nums[nums.length-1]-1));
    }
}
