package com.infy.unfinished.sudokuSolver;

import java.util.*;
import java.util.stream.IntStream;

class Gross {
    public ArrayList<ArrayList<HashSet<Character>>> findAvailable(char[][] board) {
        ArrayList<ArrayList<HashSet<Character>>> available = new ArrayList<>(IntStream
                .range(0, 9)
                .mapToObj(_ -> new ArrayList<>(IntStream.range(0,9).mapToObj(_ -> new HashSet<Character>(List.of('1','2','3','4','5','6','7','8','9'))).toList()))
                .toList());

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') available.get(i).get(j).clear();
                char c = board[i][j];
                removeRow(available, i, c);
                removeColumn(available, j, c);
                removeSquare(available, i, j, c);
            }
        }

        return available;
    }

    public void removeRow(ArrayList<ArrayList<HashSet<Character>>> available, int rowNum, char value) {
        ArrayList<HashSet<Character>> row = available.get(rowNum);
        for (HashSet<Character> cell : row) {
            cell.remove(value);
        }
    }

    public void removeColumn(ArrayList<ArrayList<HashSet<Character>>> available, int columnNum, char value) {
        for (ArrayList<HashSet<Character>> row : available) {
            row.get(columnNum).remove(value);
        }
    }

    public void removeSquare(ArrayList<ArrayList<HashSet<Character>>> available, int rowNum, int columnNum, char value) {
        int greaterRow = rowNum / 3;
        int greaterColumn = columnNum / 3;
        for (int i = greaterRow * 3; i < (greaterRow * 3) + 3; i++) {
            for (int j = greaterColumn * 3; j < (greaterColumn * 3) + 3; j++) {
                available.get(i).get(j).remove(value);
            }
        }
    }

    public boolean boardFinished(char[][] board) {
        return Arrays.stream(board).flatMap(a -> String.valueOf(a).chars().mapToObj(c -> (char) c)).noneMatch(a -> a == '.');
    }

    public void solveSudoku(char[][] board) {
        ArrayList<ArrayList<HashSet<Character>>> available = findAvailable(board);
        Stack<Character> backup = new Stack<>();
        while (!boardFinished(board)) {
            boolean oneFound = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != '.') available.get(i).get(j).clear();
                    if (available.get(i).get(j).size() == 1) {
                        board[i][j] = (char) available.get(i).get(j).toArray()[0];
                        removeRow(available, i, board[i][j]);
                        removeColumn(available, j, board[i][j]);
                        removeSquare(available, i, j, board[i][j]);
                    }
                }
            }
        }

        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }
}
