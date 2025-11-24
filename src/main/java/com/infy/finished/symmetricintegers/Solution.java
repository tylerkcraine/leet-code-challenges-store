package com.infy.finished.symmetricintegers;

import java.util.Arrays;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int total = 0;
        for (int i = low; i <= high; i++) {
            char[] thing = Integer.toString(i).toCharArray();
            if (thing.length % 2 != 0)
                continue;
            int startTotal = 0;
            int endTotal = 0;
            for (int j = 0; j < thing.length/2; j++) {
                startTotal += Integer.parseInt(String.valueOf(thing[j]));
            }

            for (int k = thing.length/2; k < thing.length; k++) {
                endTotal += Integer.parseInt(String.valueOf(thing[k]));
            }

            if (startTotal == endTotal)
                total += 1;
        }
        return total;
    }
}
