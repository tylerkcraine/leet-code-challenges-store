package com.infy.circles;

public class Main {
    public static void main(String[] args) {
        int[][] circle = {{2,2,2}, {3,4,1}, {0,0,10}};
        Solution s = new Solution();
        System.out.println(s.countLatticePoints(circle));
    }
}
