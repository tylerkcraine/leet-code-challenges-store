package com.infy.subtreesum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        subtreeSum(root, sumCount);
        Integer max = null;
        ArrayList<Integer> maxes = new ArrayList<>();

        for (int i : sumCount.keySet()) {
            if (max == null || max < sumCount.get(i)) {
                maxes.clear();
                max = sumCount.get(i);
                maxes.add(i);
            } else if (max == i) {
                maxes.add(i);
            }
        }

        System.out.println(maxes);

        return maxes.stream().mapToInt(a -> a).toArray();
    }

    public int subtreeSum(TreeNode node, HashMap<Integer,Integer> count) {
        if (node == null)
            return 0;
        int total = node.val + subtreeSum(node.left, count) + subtreeSum(node.right, count);
        int c = count.getOrDefault(total, 0);
        count.put(total, c+1);
        return total;
    }
}
