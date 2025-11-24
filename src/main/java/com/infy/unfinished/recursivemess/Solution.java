package com.infy.unfinished.recursivemess;

import java.util.Arrays;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (allZeros(nums)) {
            return 0;
        }

        Integer min = null;
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                for (int dec = 0; dec <= query[2]; dec++) {
                    if (nums[i] - dec < 0)
                        continue;
                    nums[i] -= dec;
                    int result = minZeroArray(nums, Arrays.copyOfRange(queries, 1, queries.length));
                    nums[i] += dec;
                    if (min == null)
                        min = result;
                    min = Math.min(min, result);
                }
            }
        }
        if (min == null)
            return -1;
        return 1 + min;
    }

    public boolean allZeros(int[] nums) {
        for (int i : nums) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minZeroArray(new int[]{4,3,2,1}, new int[][]{{1,3,2},{0,2,1}});
    }
}
