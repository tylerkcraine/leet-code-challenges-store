package com.infy.finished.reorderlogfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] results = new String[logs.length];
        List<String> words = Arrays.stream(logs).filter(s -> !isNum(s)).sorted((a,b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            if (split1[1].equals(split2[1]))
                return split1[0].compareTo(split2[0]);
            return split1[1].compareTo(split2[1]);
        }).toList();
        List<String> nums = Arrays.stream(logs).filter(this::isNum).toList();
        int i = 0;
        for (String s : words) {
            results[i] = s;
            i++;
        }
        for (String s : nums) {
            results[i] = s;
            i++;
        }
        return results;
    }

    public boolean isNum(String s) {
        String splitString = s.split(" ", 2)[1];
        for (char c : splitString.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isWhitespace(c))
                return false;
        }
        return true;
    }
}
