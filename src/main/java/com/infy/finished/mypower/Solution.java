package com.infy.finished.mypower;


// https://leetcode.com/problems/powx-n/submissions/1518061790/
class Solution {
    public double myPow(double x, int n) {
        System.out.println(x + " " + n);
        if (n == 0)
            return 1;
        if (n == 2)
            return x*x;
        if (n < 0)
            return 1 / myPow(x,Math.abs(n));
        if (n % 2 == 0)
            return myPow(x*x, n/2);
        else
            return x * myPow(x*x, (n-1)/2);
    }
}