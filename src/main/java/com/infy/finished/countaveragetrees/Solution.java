package com.infy.finished.countaveragetrees;

import java.util.HashMap;

class Solution {

    private HashMap<TreeNode, Integer> sumCache;
    private HashMap<TreeNode, Integer> countCache;
    private Integer countResult;

    public int averageOfSubtree(TreeNode root) {
        sumCache = new HashMap<>();
        countCache = new HashMap<>();
        countResult = 0;
        findAvg(root);
        return countResult;
    }

    public void findAvg(TreeNode root) {
        if (root == null)
            return;

        findAvg(root.left);
        findAvg(root.right);

        int sum = sumTree(root);
        int count = countTree(root);
        int avg = sum / count;

        if (avg == root.val)
            countResult++;
    }

    public int sumTree(TreeNode root) {
        if (sumCache.containsKey(root))
            return sumCache.get(root);
        if (root == null)
            return 0;

        int result = root.val + sumTree(root.left) + sumTree(root.right);
        sumCache.put(root, result);
        return result;
    }

     public int countTree(TreeNode root) {
        if (countCache.containsKey(root))
            return countCache.get(root);
        if (root == null)
            return 0;

        int result = 1 + countTree(root.left) + countTree(root.right);
        countCache.put(root, result);
        return result;
     }
}
