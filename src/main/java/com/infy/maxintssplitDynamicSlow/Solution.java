package com.infy.maxintssplitDynamicSlow;

import java.util.*;
import java.util.stream.LongStream;

class Solution {

    public HashMap<String, List<Long>> cache = new HashMap<>();

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = maximumEvenSplit(finalSum, new TreeSet<>());
        if (result.size() == 1 && result.get(0) % 2 != 0) {
            return new ArrayList<>();
        } else {
            return result;
        }
    }

    public List<Long> maximumEvenSplit(long finalSum, TreeSet<Long> previous) {
        if (finalSum == 2) {
            return new ArrayList<>(Collections.singletonList(2L));
        } else if (finalSum == 4) {
            return new ArrayList<>(Collections.singletonList(4L));
        } else if (finalSum == 6) {
            return new ArrayList<>(Arrays.asList(2L,4L));
        } else if (cache.containsKey(finalSum + " " + previous)) {
            return cache.get(finalSum + " " + previous);
        }

        ArrayList<List<Long>> results = new ArrayList<>();
        LongStream.range(2, finalSum).filter((a) -> a % 2 == 0).filter((a) -> !previous.contains(a)).forEach((a) -> {
            TreeSet<Long> newPrevious = new TreeSet<>(previous);
            newPrevious.add(a);
            if (previous.contains(a)) {
                System.out.println("oh no");
            }
            List<Long> r = maximumEvenSplit(finalSum-a, newPrevious);
            if (!r.contains(a) && !r.isEmpty()) {
                r.add(a);
                results.add(r);
            }
        });

        List<Long> winner = getWinner(results);
        if (winner != null) {
            cache.put(finalSum + " " + previous.toString(), winner);
            return winner;
        } else {
            return new ArrayList<>();
        }
    }


    public List<Long> getWinner(List<List<Long>> results) {
        List<Long> winner = null;
        for (List<Long> list : results) {
            if (winner == null || winner.size() < list.size())
                winner = list;
        }

        return winner;
    }
}
