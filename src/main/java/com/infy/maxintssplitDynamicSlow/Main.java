package com.infy.maxintssplitDynamicSlow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Long> thing = s.maximumEvenSplit(150);
        long sum = 0;
        for (long i : thing) {
            sum += i;
            System.out.println(i);
        }
        System.out.println(sum);
    }
}
