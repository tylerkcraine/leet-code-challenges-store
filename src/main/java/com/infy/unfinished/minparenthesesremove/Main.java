package com.infy.unfinished.minparenthesesremove;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(s.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(s.minRemoveToMakeValid("))(("));
        System.out.println(s.minRemoveToMakeValid("(abc)(abc)(abc)"));
        System.out.println(s.minRemoveToMakeValid("())()((("));
    }
}
