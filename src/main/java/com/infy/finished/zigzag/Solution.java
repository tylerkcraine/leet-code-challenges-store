package com.infy.finished.zigzag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        ArrayList<ArrayList<Character>> lines = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lines.add(new ArrayList<>());
        }

        int tracker = 0;
        boolean up = true;
        for (char c : s.toCharArray()) {
            lines.get(tracker).add(c);
            if (tracker == 0)
                up = true;
            if (tracker == lines.size()-1)
                up = false;

            if (up)
                tracker++;
            else
                tracker--;
        }

        StringBuilder result = new StringBuilder();
        lines.stream().flatMap(Collection::stream).forEach(result::append);
        return result.toString();
    }
}

