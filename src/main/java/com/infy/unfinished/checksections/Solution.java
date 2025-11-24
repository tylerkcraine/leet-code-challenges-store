package com.infy.unfinished.checksections;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.stream.IntStream;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        HashSet<Integer> validHorizontal = IntStream.range(1,n).collect(HashSet::new, HashSet::add, AbstractCollection::addAll);
        HashSet<Integer> validVertical = IntStream.range(1,n).collect(HashSet::new, HashSet::add, AbstractCollection::addAll);
        HashSet<Integer> containsRectangleVertical = new HashSet<>();
        HashSet<Integer> containsRectangleHorizontal = new HashSet<>();

        for (int[] rectangle : rectangles) {
            int startX = rectangle[0];
            int endX = rectangle[2];
            containsRectangleHorizontal.add(startX);
            for (int i = startX + 1; i < endX; i++) {
                validVertical.remove(i);
                containsRectangleVertical.add(i);
            }

            int startY = rectangle[1];
            int endY = rectangle[3];
            containsRectangleHorizontal.add(startY);
            for (int i = startY+1; i < endY; i++) {
                validHorizontal.remove(i);
                containsRectangleHorizontal.add(i);
            }
        }

        System.out.println(validHorizontal);
        return false;
    }

//    public boolean validRange(int start, int end, HashSet<Integer> domains) {
//
//    }
}
