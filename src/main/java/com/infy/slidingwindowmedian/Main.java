package com.infy.slidingwindowmedian;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        BadAgainSolution s = new BadAgainSolution();
        File f = new File(Main.class.getResource("/medians.txt").toURI());
        Scanner scanner = new Scanner(f);
        ArrayList<Integer> ints = new ArrayList<>();
        while (scanner.hasNext()) {
            ints.add(scanner.nextInt());
        }
        double[] thing = s.medianSlidingWindow(ints.stream().mapToInt(a -> a).toArray(), 5000);
        System.out.println(Arrays.toString(thing));
    }
}
