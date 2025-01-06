package com.infy.maxBST;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

class Solution {
    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;

        int result;
        if (validBST(root))
            result = root.val + maxSumBST(root.left) + maxSumBST(root.right);
        else
            result = Integer.max(maxSumBST(root.left), maxSumBST(root.right));

        return Math.max(result, 0);
    }

    public boolean validBST(TreeNode root) {
        if (root == null)
            return true;

        Integer maxLeft = maxNodeVal(root.left, Comparator.naturalOrder());
        Integer minRight = maxNodeVal(root.right, (a, b) -> Integer.compare(b, a));

        boolean validLeft = (maxLeft == null || maxLeft < root.val) && validBST(root.left);
        boolean validRight = (minRight == null || root.val < minRight) && validBST(root.right);
        return validLeft && validRight;
    }

    private Integer maxNodeVal(TreeNode node, Comparator<Integer> maximizeFunction) {
        if (node == null) {
            return null;
        }

        Integer right = maxNodeVal(node.right, maximizeFunction);
        Integer left = maxNodeVal(node.left, maximizeFunction);

        Optional<Integer> max = Stream.of(node.val,right,left).filter(Objects::nonNull).max(maximizeFunction);
        return max.get();
    }
}
