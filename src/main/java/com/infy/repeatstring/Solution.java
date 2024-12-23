package com.infy.repeatstring;

import java.util.Arrays;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0,i);
            if (s.length() % sub.length() != 0)
                continue;
            System.out.println(sub);
            String[] split = s.split(sub);
            System.out.println(Arrays.toString(split));
            if (split.length == 0 && !sub.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
