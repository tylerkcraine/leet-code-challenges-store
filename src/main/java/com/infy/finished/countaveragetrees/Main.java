package com.infy.finished.countaveragetrees;

public class Main {
    public static void main(String[] args) {
        TreeNode thing = TreeParser.parseTree(new Integer[]{4,8,5,0,1,null,6}, 0);
        Solution s = new Solution();
        s.averageOfSubtree(thing);
    }
}
