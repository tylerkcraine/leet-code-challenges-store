package com.infy.minimumoperations;

import java.util.*;

class Solution {

    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return y - x;
        }

        if (x % 11 == 0) {
            return 1 + minimumOperationsToMakeEqual(x/11,y);
        } else if (x % 5 == 0) {
            return 1 + minimumOperationsToMakeEqual(x/5,y);
        }
        int mul = nearestMultiple(x);
        if (Math.abs(x-mul) >= Math.abs(x-y))
            mul = y;
        if (mul > x) {
            return 1 + minimumOperationsToMakeEqual(x+1,y);
        } else {
            return 1 + minimumOperationsToMakeEqual(x-1,y);
        }


    }

    public Integer nearestMultiple(int x) {
        int left5 = (x/5)*5;
        int right5 = (left5) + 5;

        int left11 = (x/11)*11;
        int right11 = left11 + 11;

        Integer minNum = null;
        Integer minDistance = null;
        for (int i : List.of(left11, left5, right5, right11)) {
            int distance = Math.abs(x-i);
            if (minDistance == null || distance < minDistance) {
                minDistance = distance;
                minNum = i;
            }
        }

        return minNum;
    }
}
