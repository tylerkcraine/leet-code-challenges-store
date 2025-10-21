package com.infy.chalkreplacer;

import java.util.Arrays;

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        boolean studentFound = false;
        int foundStudent = 0;
        int remainingChalk = k;

        long sum = Arrays.stream(chalk).asLongStream().parallel().sum();
        if (sum < k) {
            return chalkReplacer(chalk, (int) (k % sum));
        }

        while (!studentFound) {
            for (int i = 0; i < chalk.length; i++) {
                remainingChalk -= i;
                if (remainingChalk < 0) {
                    foundStudent = i;
                    studentFound = true;
                    break;
                }
            }
        }

        return foundStudent;
    }
}
