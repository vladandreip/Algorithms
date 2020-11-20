package com.company.StringManipulation;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args){
        makeAnagram("abc", "cab");
    }

    static int makeAnagram(String a, String b) {

        int[] ascii = new int[26];
        a.chars().forEach(value -> {
            ascii[97 - value]++;
        });

        b.chars().forEach(value -> ascii[97 - value]--);

        System.out.println(Arrays.stream(ascii).map(Math::abs).sum());

        return 0;
    }
}
