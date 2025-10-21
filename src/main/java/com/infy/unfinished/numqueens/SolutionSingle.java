package com.infy.unfinished.numqueens;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SolutionSingle {
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
        HashSet<HashSet<Point>> result = elimination(n, new HashSet<>(), n);
        return result.stream().map(a -> process(a, n)).toList();
    }

    public HashSet<HashSet<Point>> elimination(int n, HashSet<Point> queens, int ogSize) {
        if (cache.containsKey(n + " " + queens + " " + ogSize))
            return cache.get(n + " " + queens + " " + ogSize);

        if (n == 0) {
            HashSet<HashSet<Point>> terminal = new HashSet<>();
            terminal.add(queens);
            cache.put(n + " " + queens + " " + ogSize, terminal);
            return terminal;
        }
        HashSet<HashSet<Point>> result = new HashSet<>();
        
        // finding x and ys not already containing a queen
        Set<Integer> xs = IntStream
                .range(0, ogSize)
                .filter(a -> !queens
                        .stream()
                        .map(Point::x)
                        .collect(Collectors.toSet())
                        .contains(a))
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> ys = IntStream
                .range(0, ogSize)
                .filter(a -> !queens
                        .stream()
                        .map(Point::y)
                        .collect(Collectors.toSet())
                        .contains(a))
                .boxed()
                .collect(Collectors.toSet());
        
        // iterating over possible points
        for (int i : xs) {
            for (int j : ys) {
                Point newPoint = new Point(i, j);
                // Testing if the point is on any queen diagonals
                if (validDiag(newPoint, queens)) {
                    HashSet<Point> clone = (HashSet<Point>) queens.clone();
                    clone.add(newPoint);
                    result.addAll(elimination(n-1, clone, ogSize)); // adds to result if valid solution found
                }
            }
        }
        cache.put(n + " " + queens + " " + ogSize, result);
        return result;
    }

    private boolean validDiag(Point p, HashSet<Point> queens) {
        for (Point q : queens) {
            if (slope(q, p) == 1.0)
                return false;
        }
        return true;
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
