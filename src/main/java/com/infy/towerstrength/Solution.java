package com.infy.towerstrength;

import java.util.*;

class Solution {
    public record Point(int x, int y){}

    public int[] bestCoordinate(int[][] towers, int radius) {
        HashMap<Point, Double> points = new HashMap<>();
        Double maxQuality = null;
        ArrayList<Point> maxPoint = new ArrayList<>();
        for (int[] tower : towers) {
            for (int x = tower[0]-radius; x <= tower[0]+radius; x++) {
                int[] range = circleLineRange(tower,radius,x);
                for (int y = range[0]; y <= range[1]; y++) {
                    Point p = new Point(x, y);
                    double totalQuality = points.getOrDefault(p, 0.0);
                    double quality = Math.floor(tower[2] / (1 + distance(p.x(), p.y(), tower[0], tower[1])));
                    points.put(p, totalQuality + quality);
                    if (maxQuality == null || totalQuality + quality > maxQuality) {
                        maxQuality = totalQuality + quality;
                        maxPoint.clear();
                        maxPoint.add(p);
                    } if (totalQuality + quality == maxQuality) {
                        maxPoint.add(p);
                    }
                }
            }
        }

        Point result = findLexicalPositiveMinimumPoint(maxPoint);
        if (maxQuality == 0.0) {
            return new int[] {0,0};
        }
        return new int[] {result.x(), result.y()};
    }

    public int[] circleLineRange(int[] center, int radius, int x) {
        // using the equation for a circle (x-h)^2 + (y-k)^2 = r^2 solved for y
        // two values because of the square root in the solution
        double neg = (-Math.sqrt(Math.pow(radius,2)-Math.pow(x-center[0],2))) + center[1];
        double pos = (Math.sqrt(Math.pow(radius,2)-Math.pow(x-center[0],2))) + center[1];

        // handling conversion to integer point
        // clamping inside the circle if a y point doesn't fall right on an integer point
        int intNeg = (neg % 1 == 0) ? (int) neg : (int) Math.ceil(neg);
        int intPos = (pos % 1 == 0) ? (int) pos : (int) Math.floor(pos);

        return new int[] {intNeg,intPos};
    }

    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2));
    }

    public Point findLexicalPositiveMinimumPoint(ArrayList<Point> points) {
        Comparator<Point> pointComparator = (a, b) -> {
            if (a.x == b.x)
                return a.y - b.y;
            return a.x - b.x;
        };

        return points
                .stream()
                .sorted(pointComparator)
                .filter(a -> a.x() >= 0 && a.y() >= 0)
                .limit(1)
                .toList()
                .getFirst();
    }
}
