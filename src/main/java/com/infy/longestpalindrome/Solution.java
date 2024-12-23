package com.infy.longestpalindrome;

import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = countMap.getOrDefault(c, 0);
            countMap.put(c, count+1);
        }

        int total = 0;
        boolean remaining = false;
        for (char c : countMap.keySet()) {
            Integer count = countMap.get(c);
            while (count >= 2) {
                count -= 2;
                total += 2;
            }
            if (count == 1) {
                remaining = true;
            }
        }
        System.out.println(countMap);
        if (remaining)
            return total+1;
        else
            return total;
    }
}
