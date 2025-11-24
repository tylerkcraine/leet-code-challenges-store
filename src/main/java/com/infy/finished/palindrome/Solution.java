package com.infy.finished.palindrome;

import java.util.Arrays;

class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : lower.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c))
                sb.append(c);
        }

        int start = 0;
        int end = sb.length();

        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
