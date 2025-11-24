package com.infy.unfinished.formteams;

import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        TreeMap<Integer, Integer> countUp = new TreeMap<>();
        TreeMap<Integer, Integer> countDown = new TreeMap<>();
        ArrayList<Integer[]> rightSide = new ArrayList<>();
        ArrayList<Integer[]> leftSide = new ArrayList<>();
        int total = 0;

        for (int j : rating) {
            Integer occurrences = countUp.getOrDefault(j, 0);
            countUp.put(j, occurrences + 1);
        }

        for (int i = 0; i < rating.length; i++) {
            Integer[] rightEntry = new Integer[2];
            Integer[] leftEntry = new Integer[2];

            int ltTotal = 0;
            for (Integer j : countUp.headMap(rating[i], false).keySet()) {
                ltTotal += countUp.get(j);
            }
            rightEntry[0] = ltTotal;

            int gtTotal = 0;
            for (Integer j : countUp.tailMap(rating[i], false).keySet()) {
                gtTotal += countUp.get(j);
            }

            rightEntry[1] = gtTotal;
            rightSide.add(rightEntry);

            int ltTotalLeft = 0;
            for (Integer j : countDown.headMap(rating[i], false).keySet()) {
                ltTotalLeft += countUp.get(j);
            }
            leftEntry[0] = ltTotalLeft;

            int gtTotalLeft = 0;
            for (Integer j : countDown.tailMap(rating[i], false).keySet()) {
                gtTotalLeft += countUp.get(j);
            }

            leftEntry[1] = gtTotalLeft;
            leftSide.add(rightEntry);


            int removeCount = countUp.get(rating[i]);
            countUp.put(rating[i], removeCount-1);
            countDown.put(rating[i], countDown.getOrDefault(rating[i], 0)+1);
        }

        for (int i = 0; i < rating.length; i++) {
            Integer[] left = leftSide.get(i);
            Integer[] right = rightSide.get(i);

            total += left[0] + right[1];
            total += left[1] + right[0];
        }
        return total;
    }
}
