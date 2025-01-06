package com.infy.towerstrength;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] towers = {{1,2,5},{2,1,7},{3,1,9}};
        int radius = 2;

        int[][] towers1  = {{42,0,0}};
        int radius1 = 7;

        int[][] towers2 = {{14,28,43},{2,7,6},{23,9,36},{44,49,10},{32,42,27},{3,34,25},{29,12,44},{10,10,50},{27,24,26}};
        int radius2 = 50;

        Solution s = new Solution();
        int[] i = s.bestCoordinate(towers2, radius2);
        System.out.println(Arrays.toString(i));
    }
}
