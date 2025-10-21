package com.infy.unfinished.numqueens;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> solution = s.solveNQueens(9);
        for (List<String> list : solution) {
            for (String st : list) {
                System.out.println(st);
            }
            System.out.println();
        }
    }
}
