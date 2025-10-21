package com.infy.finished.maxbst;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeParser.parseTree(new Integer[]{4,3,null,1,2}, 0);
        Solution s = new Solution();
        s.maxSumBST(root);
    }
}
