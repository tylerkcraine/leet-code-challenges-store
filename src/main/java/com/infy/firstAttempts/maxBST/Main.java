package com.infy.firstAttempts.maxBST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        TreeNode root = TreeParser.parseTree(new Integer[]{5,4,8,3,null,6,3}, 0);
        ArrayList<Integer> thing = new ArrayList<>();
        File file = new File("C:\\Users\\tyler.craine\\OneDrive - Infosys Limited\\Documents\\IntelliJ Projects\\leetCode\\src\\main\\resources\\bigBst.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("null"))
                thing.add(null);
            else
                thing.add(Integer.parseInt(input));
        }
        Solution s = new Solution();
        Integer[] bigBadBst = new Integer[thing.size()];
        for (int i = 0; i < thing.size(); i++) {
            bigBadBst[i] = thing.get(i);
        }
        TreeNode root = TreeParser.parseTree(bigBadBst, 0);
        int result = s.maxSumBST(root);
        System.out.println(result);
    }
}
