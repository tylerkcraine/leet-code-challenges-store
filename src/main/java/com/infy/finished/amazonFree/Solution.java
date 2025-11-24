package com.infy.finished.amazonFree;

import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public int kthFactor(int n, int k) {
        int start = 1;
        int end = n;TreeSet<Integer> factors = new TreeSet<>();

        while (start < end) {
            if (n % start == 0) {
                end = n / start;
                factors.add(start);
                factors.add(end);
            }
            start++;
        }

        if (k > factors.size())
            return -1;
        for (int i = 0; i < k-1; i++) {
            factors.removeFirst();
        }
        return factors.getFirst();
    }

    public int partitionString(String s) {
        int total = 0;
        HashSet<Character> thing = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (thing.contains(s.charAt(i))) {
                total++;
                thing.clear();
            } else {
                thing.add(s.charAt(i));
            }
        }
        return total;
    }
}
