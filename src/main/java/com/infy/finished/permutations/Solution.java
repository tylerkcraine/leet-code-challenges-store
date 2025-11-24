package com.infy.finished.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
       if (nums.length == 1) {
           return List.of(List.of(nums[0]));
       }
       List<List<Integer>> result = new ArrayList<>();

       for (int i = 0; i < nums.length; i++) {
           int[] cut = IntStream
                   .concat(Arrays.stream(nums,0,i),Arrays.stream(nums,i+1,nums.length))
                   .toArray();
           List<List<Integer>> temp =  permute(cut);
           for (List<Integer> j : temp) {
               ArrayList<Integer> temp2 = new ArrayList<>();
               temp2.add(nums[i]);
               temp2.addAll(j);
               result.add(temp2);
           }
       }
       return result;
    }
}
