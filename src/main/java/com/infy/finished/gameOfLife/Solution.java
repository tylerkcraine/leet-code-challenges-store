package com.infy.finished.gameOfLife;

import java.util.List;
import java.util.stream.IntStream;

class Solution {
    private final static List<int[]> moves = IntStream
            .rangeClosed(-1, 1)
            .boxed()
            .flatMap(i -> IntStream.rangeClosed(-1,1).boxed().map(j -> new int[]{i,j}))
            .filter(i -> i[0] != i[1] || (i[0] != 0 && i[1] != 0))
            .toList();

    public void gameOfLife(int[][] board) {

        int[][] newBoard = process(board);
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, board[0].length);
        }
    }

    public static int[][] process(int[][] board) {
        return IntStream.range(0, board.length)
                .boxed()
                .parallel()
                .map(i -> IntStream
                        .range(0, board[0].length)
                        .map(j -> result(board[i][j], count(board,i,j)))
                        .toArray()
                )
                .toArray(int[][]::new);
    }

    public static int count(int[][] board, int i, int j) {
        return Solution.moves.stream()
                .map(n -> new int[]{i+n[0], j+n[1]})
                .parallel()
                .filter(n -> 0 <= n[0] && n[0] < board.length)
                .filter(n -> 0 <= n[1] && n[1] < board[0].length)
                .map(n -> board[n[0]][n[1]])
                .mapToInt(n -> n)
                .sum();
    }

    public static int result(int throng, int count) {
        if (throng == 1) {
            if (count > 3)
                return 0;
            if (count < 2)
                return 0;
            return 1;
        } else {
            if (count == 3)
                return 1;
            else
                return 0;
        }
    }
}
