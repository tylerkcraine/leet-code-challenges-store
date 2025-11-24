package com.infy.unfinished.shortedcommonsubstring;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.contains(str2))
            return str1;
        if (str2.contains(str1))
            return str2;

        String maxString = str1.length() > str2.length() ? str1 : str2;
        String minString = str1.length() <= str2.length() ? str1 : str2;

        Set<String> startStrings = new TreeSet<>((a,b) -> b.length() - a.length());
        for (int i = 0; i < minString.length(); i++) {
            startStrings.add(minString.substring(i));
        }

        Set<String> endStrings = new TreeSet<>((a,b) -> b.length() - a.length());
        for (int i = 0; i < minString.length(); i++) {
            endStrings.add(minString.substring(0,i+1));
        }

        String start = "";
        for (String s : startStrings) {
            if (maxString.startsWith(s)) {
                start = maxString.replaceFirst(s, minString);
                break;
            }
        }

        String end = "";
        for (String s : endStrings) {
            if (maxString.endsWith(s)) {
                end = maxString.substring(0,maxString.length() - s.length()).concat(minString);
                break;
            }
        }
        System.out.println(start);
        System.out.println(end);

        return start.length() <= end.length() ? start : end;
    }
}
