package com.infy.finished.validsudoku;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> columnMap = new HashMap<>();
        HashMap<String, HashSet<Character>> squareMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;

                String cell = i/3 + " " + j/3;
                rowMap.computeIfAbsent(i, HashSet::new);
                columnMap.computeIfAbsent(j, HashSet::new);
                squareMap.computeIfAbsent(cell, _ -> new HashSet<>());

                char c = board[i][j];
                if (rowMap.get(i).contains(c) || columnMap.get(j).contains(c) || squareMap.get(cell).contains(c))
                    return false;

                rowMap.get(i).add(c);
                columnMap.get(j).add(c);
                squareMap.get(cell).add(c);
            }
        }
        return true;
    }
}
