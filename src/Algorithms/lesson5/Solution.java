package Algorithms.lesson5;

import Algorithms.lesson5.backPack.BackPack;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        BackPack backPack = new BackPack(8);
        ArrayList<BackPack.Item> list = new ArrayList<>();
        list.add(new BackPack.Item("Книга", 1, 600));
        list.add(new BackPack.Item("Бинокль", 2, 5000));
        list.add(new BackPack.Item("Аптечка", 4, 1500));
        list.add(new BackPack.Item("Ноутбук", 2, 40000));
        list.add(new BackPack.Item("Котелок", 1, 500));

        backPack.makePools(list);
        backPack.displayContains();

        System.out.println();
        System.out.println(System.currentTimeMillis() - time);

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

    private static int sqr(int n, int s) {
        if (s == 1) {
            return n;
        }

        if (s < 0) {
            return 1;
        }

        return  n * sqr(n, --s);
    }

}
