package Algorithms.lesson5;

import java.util.HashSet;
import java.util.Set;

public class Anagram {

    private char[] word;
    private Set<String> result = new HashSet<>();

    public Anagram(String word) {
        this.word = word.toCharArray();
    }

    public void getAnagram() {
        if (word.length < 2) {
            System.out.println(String.valueOf(word));
            return;
        }

        getAnagram(word.length);

        for (String anagram : result) {
            System.out.println(anagram);
        }
    }

    private void getAnagram(int length) {
        if (length == 1) return;

        for (int i = 0; i < length; i++) {
            getAnagram(length - 1);
            result.add(String.valueOf(word));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = word.length - length;
        char temp = word[pos];

        for (int i = pos + 1; i < word.length; i++) {
            word[i - 1] = word[i];
        }

        word[word.length - 1] = temp;
    }
}
