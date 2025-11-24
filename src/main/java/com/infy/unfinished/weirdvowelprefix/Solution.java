package com.infy.unfinished.weirdvowelprefix;

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;
        ArrayList<HashMap<Character,Integer>> prefixes = new ArrayList<>();
        int total = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a')
                a_count++;
            if (c == 'b')
                b_count++;
            if (c == 'c')
                c_count++;


            prefixes.add(new HashMap<>(Map.of('a', a_count, 'b', b_count, 'c', c_count)));
        }

        for (int i = 1; i <= prefixes.size(); i++) {
            total += sumWindow(prefixes, i);
        }

        return total;
    }

    public int sumWindow(ArrayList<HashMap<Character,Integer>> prefixes, int windowSize) {
        Integer left = null;
        Integer right = windowSize-1;
        int total = 0;

        while (right < prefixes.size()) {
            if (validWindow(left==null ? null : prefixes.get(left), prefixes.get(right)))
                total++;

            left = left==null ? 0 : left+1;
            right += 1;
        }

        return total;
    }

    public boolean validWindow(HashMap<Character,Integer> left, HashMap<Character,Integer> right) {
        if (left == null) {
            for (Character c : right.keySet()) {
                if (right.get(c) == 0)
                    return false;
            }
            return true;
        }

        for (Character c : left.keySet()) {
            if (right.get(c) - left.get(c) == 0)
                return false;
        }
        return true;
    }
}
