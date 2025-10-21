package com.infy.guardsguards;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int m = 7;
        int[][] guards = new int[][] {{1,5},{1,1},{1,6},{0,2}};
        int[][] walls = new int[][] {{0,6},{0,3},{0,5}};

        Solution s = new Solution();
        s.countUnguarded(n, m, guards, walls);
    }
}
