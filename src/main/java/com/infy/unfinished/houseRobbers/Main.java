package com.infy.unfinished.houseRobbers;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        Solution s = new Solution();
        int result = s.rob(nums);

        System.out.println(result);
    }
}
