package com.infy.finished.largesttriangle;

import java.util.Arrays;

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;

        for (int[] point1 : points) {
            for (int[] point2 : points) {
                for (int[] point3 : points)  {
                    if (Arrays.equals(point1, point2) ||
                        Arrays.equals(point2, point3) ||
                        Arrays.equals(point1, point3)) continue;

                    double triArea = area(point1, point2, point3);
                    if (maxArea < triArea)
                        maxArea = triArea;
                }
            }
        }
        return maxArea;
    }

    public double distance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

    public double area(int[] point1, int[] point2, int[] point3) {
        // implements Heron's formula
        double a = distance(point1, point2);
        double b = distance(point2, point3);
        double c = distance(point1, point3);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
}
