package com.infy.replaceCoprimes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int gcd (int a, int b) {
        if (a == b)
            return a;
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int lcm(int a, int b) {
        long abs_value = (long) a * b;
        if (a == b)
            return a;
        return (int) (Math.abs(abs_value) / gcd(a,b));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1)
            result.add(nums[0]);
        if (nums.length <= 1) {
            return result;
        }

        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (gcd(nums[start], nums[end]) > 1) {
                nums[end] = lcm(nums[start], nums[end]);
            } else {
                result.add(nums[start]);
            }
            start++;
            end ++;
        }

        if (start < nums.length)
            result.add(nums[start]);

        if (result.size() != nums.length)
            // there tends to be a filtering affect when processing the array so to save calculation was do the next iteration in reverse
            // this helps avoid multiple iterations just moving one number to the end of the list
            // may only apply to leetcode torture test cases
            return replaceNonCoprimes(result.reversed().stream().mapToInt((a)->a).toArray()).reversed();
        else
            return result;
    }
}

