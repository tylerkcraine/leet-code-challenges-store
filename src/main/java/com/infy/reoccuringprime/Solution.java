package com.infy.reoccuringprime;

import java.util.*;
import java.util.stream.LongStream;

class Solution {
    static final Map<String,int[]> directionStep = Map.of(
            "N", new int[]{-1, 0},
            "NW", new int[]{-1, 1},
            "W", new int[]{0, 1},
            "SW", new int[]{1, 1},
            "S", new int[]{1, 0},
            "SE", new int[]{1, -1},
            "E", new int[]{0, -1},
            "NE", new int[]{-1, -1}
    );

    public int mostFrequentPrime(int[][] mat) {
        HashMap<Integer, Integer> primeCount = new HashMap<>();
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                for (String direction : directionStep.keySet()) {
                    List<Integer> results = parseDirection(mat, direction, x, y);
                    for (Integer r : results) {
                        if (r > 9 && isPrime(r)) {
                            int count = primeCount.getOrDefault(r,0);
                            primeCount.put(r, count+1);
                        }
                    }
                }
            }
        }

        System.out.println(primeCount);
        Integer maxCount = null;
        Integer max = null;
        for (int i : primeCount.keySet()) {
            int count = primeCount.get(i);

            if (maxCount == null || maxCount < count || (maxCount == count && i > max)) {
                maxCount = count;
                max = i;
            }
        }
        if (max == null)
            return -1;
        return max;
    }

    private boolean isPrime(Integer n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    public List<Integer> parseDirection(int[][] mat, String direction, int x, int y) {
        if (!directionStep.containsKey(direction))
            throw new IllegalArgumentException("Direction must be a cardinal direction");

        int v = directionStep.get(direction)[0];
        int h = directionStep.get(direction)[1];

        ArrayList<Integer> results = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (y >= 0 && y < mat.length && x >= 0 && x < mat[0].length) {
            result.append(mat[y][x]);
            results.add(Integer.parseInt(result.toString()));
            y += v;
            x += h;
        }

        return results;
    }
}