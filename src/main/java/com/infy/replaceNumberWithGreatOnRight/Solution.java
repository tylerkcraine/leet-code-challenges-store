package com.infy.replaceNumberWithGreatOnRight;

class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = findGreatestOnRightOfIndex(arr,i);
        }

        return arr;
    }

    public Integer findGreatestOnRightOfIndex(int[] arr, int index) {
        Integer max = null;
        for (int i = index+1; i < arr.length; i++) {
            if (max == null || max < i)
                max = i;
        }
        return max;
    }
}