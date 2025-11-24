package com.infy.firstAttempts.loversandthetowers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        HashMap<Integer, TreeSet<Integer>> possible = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            possible.put(i, processTowers(heights, possible,i));
        }

        int tracker = 0;
        int[] results = new int[queries.length];
        for (int[] query: queries) {
            TreeSet<Integer> alicePossible =  possible.get(query[0]);
            TreeSet<Integer> beatricePossible = possible.get(query[1]);
            Integer result = null;
            for (Integer i : alicePossible) {
                if (beatricePossible.contains(i)) {
                    result = i;
                    break;
                }
            }
            results[tracker] = Objects.requireNonNullElse(result, -1);
            tracker++;
        }
        return results;
    }

    private TreeSet<Integer> processTowers(int[] heights, HashMap<Integer, TreeSet<Integer>> possible, int tower) {
        if (possible.containsKey(tower))
            return possible.get(tower);

        TreeSet<Integer> result = new TreeSet<>();
        result.add(tower);

        for (int i = tower + 1; i < heights.length; i++) {
            if (heights[tower] < heights[i]) {
                result.add(i);
                result.addAll(processTowers(heights,possible,i));
            }
        }

        return result;
    }
}
