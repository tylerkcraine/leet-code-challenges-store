package com.infy.circles;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    public record Point (int x, int y) {
        @Override
        public String toString() {
            return String.format("(%s, %s)", this.x(), this.y());
        }
    }

    public int countLatticePoints(int[][] circles) {
        HashSet<Point> points = new HashSet<>();

        for (int[] circle : circles) {
            int startY = circle[1] - circle[2];
            int endY = circle[1] + circle[2];

            IntStream.rangeClosed(startY, endY).forEach((y) -> {
                double[] resultRange = calcLineRange(y, circle[0], circle[1], circle[2]);
                plotPoints(resultRange, y, points);
            });
        }
        return points.size();
    }

    public double[] calcLineRange(int y,int centralX, int centralY, int r) {
        double[] result = new double[2];
        double radical = Math.sqrt(Math.pow(r,2) - Math.pow(y-centralY, 2));
        result[0] = -radical + centralX;
        result[1] = radical + centralX;
        return result;
    }

    public void plotPoints (double[] range, int y, HashSet<Point> points) {
        int start = (int) Math.ceil(range[0]);
        int end  = (int) Math.floor(range[1]);
        IntStream.rangeClosed(start, end).forEach((x) -> {
            points.add(new Point(x, y));
        });
    }
}