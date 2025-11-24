package com.infy.finished.maxbst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class Solution {
    public record Cache(HashMap<TreeNode,Integer> min, HashMap<TreeNode,Integer> max, HashMap<TreeNode,Integer> sum, HashSet<TreeNode> isBst) {}

    public Cache cache;

    public TreeNode maxNode = null;

    public Cache construct() {
        return new Cache(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashSet<>());
    }

    public int maxSumBST(TreeNode root) {
        cache = construct();
        maxNode = null;
        findBST(root);
        return Math.max(0,cache.sum().get(maxNode));
    }

    public void findBST(TreeNode root) {
        if (root == null) {
            return;
        }

        findBST(root.left);
        findBST(root.right);

        Integer min = optimize(root.right, (Comparator<Integer>) Comparator.naturalOrder().reversed(), cache.min());
        Integer max = optimize(root.left, Comparator.naturalOrder(), cache.max);
        int sum = sum(root, cache.sum());

        ArrayList<Boolean> validList = new ArrayList<>();

        if (max != null)
            validList.add(max < root.val);
        if (min != null)
            validList.add(min > root.val);
        validList.add(cache.isBst().contains(root.right) || root.right == null);
        validList.add(cache.isBst().contains(root.left) || root.left == null);

        boolean valid = true;
        for (boolean b : validList) {
            if (!valid) {
                continue;
            }
            valid = b;
        }

        if (valid) {
            cache.isBst.add(root);
            if (maxNode == null || sum > cache.sum().get(maxNode))
                maxNode = root;
        }
    }

    public Integer optimize(TreeNode root, Comparator<Integer> comparator, HashMap<TreeNode,Integer> cache) {
        if (root == null)
            return null;

        if (cache.containsKey(root))
            return cache.get(root);

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(root.val);
        if (root.right != null)
            nums.add(root.right.val);
        if (root.left != null)
            nums.add(root.left.val);

        int result = nums.stream().max(comparator).get();
        cache.put(root, result);
        return result;
    }

    public int sum(TreeNode root, HashMap<TreeNode, Integer> sumCache) {
        if (root == null)
            return 0;
        if (sumCache.containsKey(root))
            return sumCache.get(root);

        int result = Stream.of(root.val, sum(root.left, sumCache), sum(root.right, sumCache)).mapToInt(a->a).sum();
        sumCache.put(root, result);
        return result;
    }
}