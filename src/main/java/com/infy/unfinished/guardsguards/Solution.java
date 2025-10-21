package com.infy.guardsguards;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.IntStream;


// Link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
// TODO: finish
// or well probably redo since I'm running up on time constrains
class Solution {
    record Point(int x, int y) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "[" + this.x + ", " + this.y + "]";
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        HashSet<String> xAlreadyProcessed = new HashSet<>();
        HashSet<String> yAlreadyProcessed = new HashSet<>();
        int amountOfCells = (m * n) - walls.length;
        HashSet<Point> guardedCell = new HashSet<>();

        TreeMap<Integer, TreeSet<Integer>> xWallMap = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> yWallMap = new TreeMap<>();

        for (int[] wall : walls) {
            TreeSet<Integer> x = xWallMap.getOrDefault(wall[0], new TreeSet<>());
            TreeSet<Integer> y = yWallMap.getOrDefault(wall[1], new TreeSet<>());

            x.add(wall[1]);
            y.add(wall[0]);

            xWallMap.put(wall[0], x);
            yWallMap.put(wall[1], y);
        }

        for (int[] guard : guards) {
            TreeSet<Integer> xRow = xWallMap.getOrDefault(guard[0], null);
            Integer[] xBound = getGuardBounds(guard[1], xRow);

            TreeSet<Integer> yRow = yWallMap.getOrDefault(guard[1], null);
            Integer[] yBound = getGuardBounds(guard[0], yRow);


            if (xBound[0] == null) xBound[0] = 0;
            if (xBound[1] == null) xBound[1] = n - 1;

            if (yBound[0] == null) yBound[0] = 0;
            if (yBound[1] == null) yBound[1] = m - 1;

            System.out.println(Arrays.toString(guard));
            System.out.print("XBound: ");
            System.out.println(Arrays.toString(xBound));

            System.out.print("YBound");
            System.out.println(Arrays.toString(yBound) + "\n");


            if (!xAlreadyProcessed.contains(Arrays.toString(guard))) {
                for (int i = xBound[0]; i <= xBound[1]; i++) {
                    guardedCell.add(new Point(guard[0], i));
                    xAlreadyProcessed.add(Arrays.toString(new int[]{guard[0], i}));
                }
            }

            if (!yAlreadyProcessed.contains(Arrays.toString(guard))) {
                for (int i = yBound[0]; i <= yBound[1]; i++) {
                    guardedCell.add(new Point(i, guard[1]));
                    yAlreadyProcessed.add(Arrays.toString(new int[]{i, guard[1]}));
                }
            }
        }

        return amountOfCells - guardedCell.size();
    }

    public Integer[] getGuardBounds(int v, TreeSet<Integer> vSet) {
        Integer leftWall = null;
        Integer rightWall = null;

        if (vSet == null)
            return new Integer[]{leftWall,rightWall};

        for (Integer i : vSet) {
            if (i > v) {
                rightWall = i-1;
                break;
            }
        }

        for (Integer i : vSet.descendingSet()) {
            if (i < v) {
                leftWall = i+1;
                break;
            }
        }

        return new Integer[]{leftWall,rightWall};
    }
}
