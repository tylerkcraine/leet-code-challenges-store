package com.infy.finished.formteams;

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int numTeams(int[] rating) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        ArrayList<Integer[]> ltAndGt = new ArrayList<>();
        int total = 0;

        for (int j : rating) {
            Integer occurrences = count.getOrDefault(j, 0);
            count.put(j, occurrences + 1);
        }

        for (int i = 0; i < rating.length; i++) {
            Integer[] entry = new Integer[2];

            int ltTotal = 0;
            for (Integer j : count.headMap(rating[i], false).keySet()) {
                ltTotal += count.get(j);
            }
            entry[0] = ltTotal;

            int gtTotal = 0;
            for (Integer j : count.tailMap(rating[i], false).keySet()) {
                gtTotal += count.get(j);
            }

            entry[1] = gtTotal;
            ltAndGt.add(entry);

            int removeCount = count.get(rating[i]);
            count.put(rating[i], removeCount-1);
        }

        for (int i = 0; i < rating.length; i++) {
            for (int j = i+1; j < rating.length; j++) {
                if (rating[j] - rating[i] > 0) {
                    total += ltAndGt.get(j)[1];
                }
                if (rating[j] - rating[i] < 0) {
                    total += ltAndGt.get(j)[0];
                }
            }
        }
        return total;
    }
}
