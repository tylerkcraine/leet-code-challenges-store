package com.infy.finished.pizzacutter;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public static HashMap<String, Long> cache = new HashMap<>();
    public static int modBase = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        int num = (int) (waysLong(pizza,k) % modBase);
        return num;
    }

    public long waysLong(String[] pizza, int k) {
        if (Solution.cache.containsKey(Arrays.toString(pizza) + k))
            return Solution.cache.get(Arrays.toString(pizza) + k) % Solution.modBase;
        if (!validSlice(pizza))
            return 0;
        if (k == 1 && validSlice(pizza))
            return 1;

        long total = 0;
        // checking horizontal slices
        for (int i = 1; i < pizza.length; i++) {
            String[] top = Arrays.copyOfRange(pizza, 0, i);
            String[] bottom = Arrays.copyOfRange(pizza,i, pizza.length);
            if (validSlice(top) && validSlice(bottom))
                total += waysLong(bottom, k - 1);
        }

        // checking vertical slices
        for (int i = 1 ; i < pizza[0].length(); i++) {
            final int temp = i;
            String[] left = Arrays.stream(pizza).map(s -> s.substring(0, temp)).toArray(String[]::new);
            String[] right = Arrays.stream(pizza).map(s -> s.substring(temp)).toArray(String[]::new);
            if (validSlice(left) && validSlice(right))
                total += waysLong(right, k-1);
        }

        Solution.cache.put(Arrays.toString(pizza) + k, total);
        return total % Solution.modBase;
    }

    private boolean validSlice(String[] pizza) {
        for (String s : pizza) {
            if (s.contains("A")) return true;
        }
        return false;
    }
}