package com.infy.finished.bofa;

import java.util.stream.IntStream;

public class MainOne {
    public static void main(String[] args) {
        SolutionOne s = new SolutionOne();
        SolutionOne.Split split = s.separate(IntStream.range(1,101).toArray());
        System.out.println(split.odd());
        System.out.println(split.even());
    }
}
