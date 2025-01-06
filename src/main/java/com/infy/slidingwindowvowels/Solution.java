package com.infy.slidingwindowvowels;

class Solution {
    public int maxVowels(String s, int k) {
//        HashSet<Character> vowelSet = new HashSet<>();
//        vowelSet.add('a');
//        vowelSet.add('e');
//        vowelSet.add('i');
//        vowelSet.add('o');
//        vowelSet.add('u');
//        vowelSet.contains(s.charAt(i))

        int windowStart = 0;
        int windowEnd = k;

        int count = 0;
        for (int i = windowStart; i < windowEnd; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int max = count;
        while (windowEnd < s.length()) {
            if (isVowel(s.charAt(windowStart))) {
                count--;
            }
            if (isVowel(s.charAt(windowEnd))) {
                count++;
            }
            if (count > max) {
                max = count;
            }
            windowStart++;
            windowEnd++;
        }

        return max;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
