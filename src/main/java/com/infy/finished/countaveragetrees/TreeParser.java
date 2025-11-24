package com.infy.finished.countaveragetrees;

public class TreeParser {
    public static TreeNode parseTree(Integer[] treeList , int i) {
        if (i >= treeList.length)
            return null;

        if (treeList[i] == null)
            return null;

        TreeNode tracker = new TreeNode(treeList[i]);
        if (i == 0) {
            tracker.left = parseTree(treeList, 1);
            tracker.right = parseTree(treeList, 2);
        }
        else {
            tracker.left = parseTree(treeList, 2*i + 1);
            tracker.right = parseTree(treeList, 2*i + 2);
        }
        return tracker;
    }
}
