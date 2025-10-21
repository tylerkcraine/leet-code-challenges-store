package com.infy.finished.bofa;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionOne {
    public record Split(ArrayList<Integer> odd, ArrayList<Integer> even) {}

    public Split separate(int[] nums) {
        Split result = new Split(new ArrayList<>(), new ArrayList<>());
        result.even().addAll(Arrays.stream(nums).filter(n -> n % 2 == 0).boxed().toList());
        result.odd().addAll(Arrays.stream(nums).filter(n -> n % 2 != 0).boxed().toList());
        return result;
    }
}
