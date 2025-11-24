package com.infy.unfinished.numqueens;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public record Point(int x, int y) implements Comparable<Point> {
        @Override
        public int compareTo(Point o) {
            if (this.x() == o.x()) {
                return this.y() - o.y();
            }
            return this.x() - o.x();
        }
    }

    private HashMap<String, HashSet<HashSet<Point>>> cache = new HashMap<>();

    public List<List<String>> solveNQueens(int n) {
        HashSet<Point> spaces = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                spaces.add(new Point(i,j));
            }
        }
        HashSet<HashSet<Point>> result = elimination(n, new HashSet<>(), spaces);
        return result.stream().map(a -> process(a, n)).toList();
    }

    public HashSet<HashSet<Point>> elimination(int n, HashSet<Point> queens, Set<Point> spaces) {
        if (cache.containsKey(queens.stream().sorted().toList().toString()))
            return cache.get(queens.stream().sorted().toList().toString());

        if (n == 0) {
            HashSet<HashSet<Point>> terminal = new HashSet<>();
            terminal.add(queens);
            cache.put(queens.stream().sorted().toList().toString(), terminal);
            return terminal;
        }
        HashSet<HashSet<Point>> result = new HashSet<>();

        // iterating over possible points
        for (Point p : spaces) {
            HashSet<Point> clone = (HashSet<Point>) queens.clone();
            clone.add(p);
            Set<Point> spaceClone = spaces
                    .stream()
                    .filter(a -> a.x() != p.x() && a.y() != p.y() && slope(a, p) != 1.0)
                    .collect(Collectors.toSet());
            result.addAll(elimination(n-1, clone, spaceClone)); // adds to result if valid solution found
        }
        cache.put(queens.stream().sorted().toList().toString(), result);
        return result;
    }

    private double slope (Point p1, Point p2) {
        return Math.abs(((double)p1.y() - (double)p2.y())/ ((double)p1.x() - (double)p2.x()));
    }

    private List<String> process(HashSet<Point> points, int size) {
        char[][] c = new char[size][size];
        for (char[] row : c) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            c[p.x()][p.y()] = 'Q';
        }
        return Arrays.stream(c).map(String::valueOf).toList();
    }
}
