package com.infy.finished.excelRanges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<String> cellsInRange(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (char c : letterRange(s.charAt(0), s.charAt(3))) {
            IntStream.rangeClosed(s.charAt(1)-48, s.charAt(4)-48).forEach(i -> result.add(c + "" + i));
        };

        return result;
    }

    public List<Character> letterRange(char start, char end) {
        return IntStream.rangeClosed(start, end).mapToObj(i -> (char) i).toList();
    }
}