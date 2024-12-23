package com.infy.slidingwindowmedian;

import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        // TODO: Finish the PriorityQueue Version of a algorithm
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>(Comparator.reverseOrder());

        throw new RuntimeException("Not implemented");
    }
}
