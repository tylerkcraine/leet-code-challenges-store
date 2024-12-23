package com.infy.chalkreplacer;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
