package com.infy.happystrings;

import java.util.*;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/solutions/
class Solution {

    Map<Character, String> availableLetters = Map.of(
            'a',"bc",
            'b',"ac",
            'c',"ab"
    );

//    HashMap<String, ArrayList<String>> cache = new HashMap<>();

    public String getHappyString(int n, int k) {
        ArrayList<String> results = generateHappyStrings(null, n, k);
        try {
            return results.get(k-1);
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    public ArrayList<String> generateHappyStrings(Character c, int length, int k) {
//        if (cache.containsKey(s+length)) {
//            return cache.get(s+length);
//        }
        ArrayList<String> returnList = new ArrayList<>();
        if (length == 0) {
            return returnList;
        }


        String rangeString;
        if (c == null)
            rangeString = "abc";
        else
            rangeString = availableLetters.get(c);
        for (int i = 0; i < rangeString.length(); i++) {
            ArrayList<String> results = generateHappyStrings(rangeString.charAt(i), length-1, k);

            if (results.isEmpty()) {
                returnList.add(String.valueOf(rangeString.charAt(i)));
            }
            for (String v : results) {
                returnList.add(rangeString.charAt(i) + v);
            }

            if (c == null && returnList.size() > k) {
                break;
            }
        }

//        cache.put(s + length, returnList);
        return returnList;
    }
}
