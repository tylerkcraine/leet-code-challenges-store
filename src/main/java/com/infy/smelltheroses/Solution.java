package com.infy.smelltheroses;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        PriorityQueue<Integer> startQueue = new PriorityQueue<>();
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        startQueue.addAll(Arrays.stream(flowers).map((a) -> a[0]).toList());
        endQueue.addAll(Arrays.stream(flowers).map((a) -> a[1]).toList());

        int[] sortedPeople = Arrays.stream(people).sorted().toArray();

        HashMap<Integer, Integer> results = new HashMap<>();
        int currentFlowersInBloom = 0;
        int flowerStart = startQueue.peek();
        for (int i : sortedPeople) {
            if (i < flowerStart) {
                results.put(i, currentFlowersInBloom);
                continue;
            }
            while (startQueue.peek() != null && startQueue.peek() <= i) {
                startQueue.poll();
                currentFlowersInBloom++;
            } while (endQueue.peek() != null && endQueue.peek() < i) {
                endQueue.poll();
                currentFlowersInBloom--;
            }
            results.put(i, currentFlowersInBloom);
        }

        return Arrays.stream(people).map(results::get).toArray();
    }
}