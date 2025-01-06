package com.infy.divide;

class Solution {
    public int divide(int dividend, int divisor) {

        int current = dividend;
        boolean subtracting = (dividend >= 0 && divisor <= 0) || (dividend <= 0 && divisor >= 0);

        int times = 0;
        while (current >= divisor || current <= divisor) {
            if (subtracting)
                current -= divisor;
            else
                current += divisor;
            times++;
        }

        return times;
    }
}
