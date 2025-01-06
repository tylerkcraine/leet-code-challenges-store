package com.infy.divide;

public class Main {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;

        Solution s = new Solution();
        int result = s.divide(dividend, divisor);
        System.out.println(result);
    }
}
