package com.infy.finished.validpairs;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String findValidPair(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = counts.getOrDefault(c, 0);
            counts.put(c, count+1);
        }

        Set<Character> valid = counts
                .keySet()
                .stream()
                .filter(a -> counts.get(a) == Integer.parseInt(String.valueOf(a)))
                .collect(Collectors.toSet());

        for (int i = 0, j = 1; j < s.length(); i++, j++) {
            if (s.charAt(i) != s.charAt(j) && valid.contains(s.charAt(i)) && valid.contains(s.charAt(j))) {
                return s.substring(i, j+1);
            }
        }

        return "";
    }
}
