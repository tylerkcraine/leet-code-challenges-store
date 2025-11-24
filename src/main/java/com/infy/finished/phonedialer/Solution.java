package com.infy.unfinished.phonedialer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    HashMap<Character,List<String>> cache = new HashMap<>(Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    ));

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        if (digits.length() == 1) {
            return cache.get(digits.charAt(0));
        }
        List<String> result = new ArrayList<>();

        List<String> process = letterCombinations(digits.substring(1));
        for (String s : cache.get(digits.charAt(0))) {
            for (String j : process) {
                result.add(s + j);
            }
        }

        return result;
    }
}
