package com.infy.unfinished.minswap;

import java.util.HashSet;

// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/description/
class Solution {
    public int minimumSwap(String s1, String s2) {
        return minimumSwapSet(s1, s2, new HashSet<>());
    }

    public int minimumSwapSet(String s1, String s2, HashSet<String> previous) {
        previous.add(s1 + s2);
        if (s1.equals(s2)){
            System.out.print(previous.size()-1);
            return previous.size()-1;
        }

        Integer result = null;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                String new1 = s1.substring(0,i) + c2 + s1.substring(i+1);
                String new2 = s2.substring(0,j) + c1 + s2.substring(j+1);
            }
        }
        return 0;
    }
}
