package com.infy.unfinished.houseRobbers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {

    public HashMap<String, Integer> cache = new HashMap<>();


    public int rob(int[] nums) {
        Set<Integer> validHouses = IntStream.range(0, nums.length).boxed().collect(Collectors.toSet());
        int result = rob(nums, validHouses);
        return result;
    }

    public int rob(int[] nums, Set<Integer> validHouses) {
        System.out.println(validHouses);
        if (cache.containsKey(validHouses.toString()))
            return cache.get(validHouses.toString());

        if (validHouses.isEmpty())
            return 0;

        if (validHouses.size() == 1)
            return nums[validHouses.stream().mapToInt(i -> i).max().getAsInt()];

        int max = 0;

        List<int[]> greed = validHouses.stream().map(i -> new int[]{i, nums[i]}).sorted(Comparator.comparingInt(a -> a[1])).toList();

        for(int[] t : greed) {
            int i = t[0];
            Set<Integer> remove = Stream.of(i, i+1, i-1)
                    .filter(n -> validHouses.contains(n))
                    .collect(Collectors.toSet());

            validHouses.removeAll(remove);
            int tempMax = max;
            max = Math.max(nums[i] + rob(nums, validHouses), max);
            validHouses.addAll(remove);
            if (max == tempMax)
                break;
        }

        cache.put(validHouses.toString(), max);
        return max;
    }
}
