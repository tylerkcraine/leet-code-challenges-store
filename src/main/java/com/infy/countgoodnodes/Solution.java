package com.infy.countgoodnodes;


// got it in one
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
class Solution {
    public int goodNodes(TreeNode root) {
        int total = 1;
        return total + goodNodesSub(root.left, root.val) + goodNodesSub(root.right, root.val);
    }

    public int goodNodesSub(TreeNode root, int max) {
        if (root == null)
            return 0;
        int tempMax = Math.max(root.val, max);
        if (root.val >= tempMax) {
            return 1 + goodNodesSub(root.left, tempMax) + goodNodesSub(root.right, tempMax);
        } else {
            return goodNodesSub(root.left, tempMax) + goodNodesSub(root.right, tempMax);
        }
    }
}
