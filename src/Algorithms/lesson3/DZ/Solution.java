package Algorithms.lesson3.DZ;

import Algorithms.lesson3.stack.Stack;
import Algorithms.lesson3.stack.StackImpl;

public class Solution {

    public static void main(String[] args) {
        String text1 = "I love Java!";
        String text2 = "my gym";


        System.out.println(text1);
        System.out.println(reverseString(text1) + "\n");
        System.out.println(text2);
        System.out.println(reverseString(text2) + "\n");


    }

    public static String reverseString(String text) {
        Stack<Character> stack = new StackImpl<>(text.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return String.valueOf(result);
    }
}
