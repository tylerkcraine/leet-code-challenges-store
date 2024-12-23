package com.infy.indyProblem;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int[][] arts = {{0,0,0,0},{0,1,1,1}};
        int[][] digs = {{0,0},{0,1}};

        solution.digArtifacts(n, arts,digs);
    }
}
