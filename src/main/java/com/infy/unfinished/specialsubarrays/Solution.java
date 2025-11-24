package com.infy.unfinished.specialsubarrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

class Solution {
    public int[] prefixThing(int[] nums) {
        int[] prefix = new int[nums.length];
        int total = 0;
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if ((nums[i] % 2 == 0) == (nums[j] % 2 == 0))
                total++;
            else {
                total--;
                if (total < 0)
                    total = 0;
            }
            prefix[i] = total;
        }
        return prefix;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = prefixThing(nums);
        System.out.println(Arrays.toString(prefix));
        return new boolean[]{true};
    }

    public boolean isSubArraySpecial(int[] nums, int start, int end) {
        return false;
    }
}
