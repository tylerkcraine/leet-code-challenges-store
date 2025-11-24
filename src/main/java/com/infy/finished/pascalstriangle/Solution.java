package com.infy.finished.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return List.of(1);

        if (rowIndex == 1)
            return List.of(1,1);

        List<Integer> previous = getRow(rowIndex-1);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        int offset = 0;
        while (previous.stream().skip(offset).limit(2).count() == 2) {
            result.add(previous.stream().mapToInt(a -> a).skip(offset).limit(2).sum());
            offset++;
        }
        result.add(1);

        return result;
    }
}
