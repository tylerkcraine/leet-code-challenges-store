package com.infy.finished.gameOfLife;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] board = IntStream
                .range(0,10000)
                .boxed()
                .map(_ -> IntStream.range(0,10000).map(_ -> r.nextInt(2)).toArray())
                .toArray(int[][]::new);

        Solution s = new Solution();
        s.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
