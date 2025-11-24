package com.infy.firstAttempts.maxBST;

import java.util.*;

/**
 * This one works but since leetcode has a strange way it handles negative this version doesn't work
 *
 */
class Solution {
    public int maxSumBST(TreeNode root) {
        HashMap<TreeNode, Integer> bsts = new HashMap<>();
        findBST(root, bsts, new HashMap<>(), new HashMap<>());
        return Math.max(bsts.values().stream().mapToInt(a->a).max().orElse(0), 0);
    }

    public int sumBst(TreeNode t, HashMap<TreeNode, Integer> sums) {
        if (t == null)
            return 0;
        if (sums.containsKey(t))
            return sums.get(t);
        int result = t.val + sumBst(t.left,sums) + sumBst(t.right,sums);
        result = Math.max(0, result);
        sums.put(t, result);
        return result;
    }

    public void findBST(TreeNode root, HashMap<TreeNode, Integer> bsts, HashMap<TreeNode,Integer> bstMins, HashMap<TreeNode,Integer> bstMaxs) {
        if (root == null) {
            return;
        }

        findBST(root.left, bsts, bstMins, bstMaxs);
        findBST(root.right, bsts, bstMins, bstMaxs);

        if (root.left == null && root.right == null) {
            bsts.put(root, root.val);
        }

        else if (root.left == null && minVal(root.right, bstMins) > root.val && bsts.containsKey(root.right)) {
            bsts.put(root, sumBst(root, bsts));
        }

        else if (root.right == null && maxVal(root.left, bstMaxs) < root.val && bsts.containsKey(root.left)) {
            bsts.put(root, sumBst(root, bsts));
        }

        else if (root.right == null || root.left == null) {
            return;
        }

        else if (maxVal(root.left, bstMaxs) < root.val && minVal(root.right, bstMins) > root.val && bsts.containsKey(root.left) && bsts.containsKey(root.right)) {
            bsts.put(root, sumBst(root, bsts));
        }
    }

    public int minVal(TreeNode root, HashMap<TreeNode,Integer> bstMin) {
        if (bstMin.containsKey(root))
            return bstMin.get(root);
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left == null)
            return Math.min(root.val, minVal(root.right, bstMin));
        if (root.right == null)
            return Math.min(root.val, minVal(root.left, bstMin));

        int temp = Math.min(root.val, minVal(root.right, bstMin));
        int result = Math.min(temp, minVal(root.left, bstMin));
        bstMin.put(root, result);
        return result;
    }

    public int maxVal(TreeNode root, HashMap<TreeNode,Integer> bstMax) {
        if (bstMax.containsKey(root))
            return bstMax.get(root);
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left == null)
            return Math.max(root.val, maxVal(root.right, bstMax));
        if (root.right == null)
            return Math.max(root.val, maxVal(root.left, bstMax));

        int temp = Math.max(root.val, maxVal(root.right, bstMax));
        int result = Math.max(temp, maxVal(root.left, bstMax));
        bstMax.put(root, result);
        return result;
    }
}
