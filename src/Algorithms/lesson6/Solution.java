package Algorithms.lesson6;

import java.util.ArrayList;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Tree<Integer>> seedling = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            seedling.add(new TreeImpl<>());
            while (seedling.get(i).deep() < 4) {
                seedling.get(i).add(getRandom());
            }
        }


//        for (Tree<Integer> tree : seedling) {
//            tree.display();
//            System.out.print("deep: " + tree.deep() + " ");
//            System.out.println(tree.isBalanced());
//        }

        System.out.println(analysis(seedling) + "% not balanced");



    }

    public static int getRandom() {
        Random random = new Random(System.currentTimeMillis());
        int max = 20;
        int min = -20;

        return min + random.nextInt(max - min + 1);
    }

    public static int analysis(ArrayList<Tree<Integer>> seedling) {
        int unBalanced = 0;

        for (Tree<Integer> tree : seedling) {
            if (!tree.isBalanced()) unBalanced++;
        }

        return unBalanced * (100 / seedling.size());
    }

}
