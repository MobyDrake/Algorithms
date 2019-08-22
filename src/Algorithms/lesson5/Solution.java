package Algorithms.lesson5;

import java.io.File;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        new Anagram("cat").getAnagram();
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return  n * factorial(--n);
    }

    private static  void viewDir(String prefix, File root) {
        if (root.isFile()) {
            System.out.println(prefix + "File: " + root.getName());
        } else {
            System.out.println(prefix + "Dir: " + root.getName());

            for (File file : Objects.requireNonNull(root.listFiles())) {
                viewDir(prefix + "  ", file);
            }
        }
    }


}
