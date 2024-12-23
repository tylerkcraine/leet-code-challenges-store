package com.infy.indyProblem;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private record Point (int x, int y) {}

    private static class Artifact {
        private HashSet<Point> spacesDug;
        private int area;
        private Point startPoint;
        private Point endPoint;

        public Artifact(int[] artArray) {
            spacesDug = new HashSet<>();
            int deltaY = artArray[3] - artArray[1];
            int deltaX = artArray[2] - artArray[0];
            area = deltaX * deltaY;
            startPoint = new Point(artArray[0], artArray[1]);
            endPoint = new Point(artArray[2], artArray[3]);
            if (startPoint.equals(endPoint)) {
                area = 1;
            }
        }

        public boolean contains(Point p) {
            return startPoint.x() <= p.x() && p.x() <= endPoint.x() &&
                    startPoint.y() <= p.y() && p.x() <= endPoint.y();
        }

        public void dig(Point p) {
            if (!this.contains(p))
                return;

            spacesDug.add(p);
        }

        public boolean dugUp() {
            return spacesDug.size() >= area;
        }
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        ArrayList<Artifact> artList = new ArrayList<>();
        for (int[] i : artifacts) {
            artList.add(new Artifact(i));
        }

        for (int[] d : dig) {
            for (Artifact a : artList) {
                a.dig(new Point(d[0], d[1]));
            }
        }

        int total = 0;
        for (Artifact a : artList) {
            if (a.dugUp()) total++;
        }

        return total;
    }
}
