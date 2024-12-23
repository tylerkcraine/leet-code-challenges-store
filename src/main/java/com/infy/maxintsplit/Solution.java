package com.infy.maxintsplit;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.LongStream;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0)
            return new ArrayList<>();
        return maximumEvenSplit(finalSum, new TreeSet<>());
    }

    public List<Long> maximumEvenSplit(long finalSum, TreeSet<Long> skipList) {
        LongStream evenStream = LongStream.rangeClosed(1,finalSum).filter((a) -> a%2 == 0);
        ArrayList<Long> list = new ArrayList<>();
        final long[] sum = {0};
        evenStream.forEach((a) -> {
            if (sum[0] + a <= finalSum && !skipList.contains(a)) {
                list.add(a);
                sum[0] += a;
            }
        });

        return list;
    }
}
