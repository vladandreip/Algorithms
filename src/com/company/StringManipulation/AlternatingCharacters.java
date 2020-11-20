package com.company.StringManipulation;

public class AlternatingCharacters {

    public static void main(String[] args) {
        String string = "AABBABBB";
        int end = 0;
        int deletions = 0;
        char letter = string.charAt(0);
        do {
            System.out.print(letter);
            System.out.print(string.charAt(end + 1));
            if (letter == string.charAt(end + 1)) {
                letter = string.charAt(end + 1);
                deletions++;
            } else {
                letter = string.charAt(end + 1);
            }
            end++;
        } while(end < string.length() - 1);
        boolean isA = true;
        boolean ok;
        boolean isB = false;
        boolean bol = true;
        //string.chars().forEach(value -> );
        int size = string.length();
        deletions = 0;
        int i;
        char charUnderTest;
        for (i = 0; i < size - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                deletions ++;
            }
        }
        System.out.println(deletions);
    }
}
