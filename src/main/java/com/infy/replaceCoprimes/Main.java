package com.infy.replaceCoprimes;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] twosAndThrees = new int[100000];
        for (int i = 0; i < twosAndThrees.length; i++){
            if (i % 2 == 0) {
                 twosAndThrees[i] = 2;
            } else {
                twosAndThrees[i] = 3;
            }
        }
        twosAndThrees[twosAndThrees.length-1] = 6;
        twosAndThrees[twosAndThrees.length-2] = 6;

        System.out.println(s.replaceNonCoprimes(twosAndThrees));
    }
}
