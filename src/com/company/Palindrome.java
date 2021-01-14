package com.company;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(optimizedSolution(12321));
    }

    static boolean optimizedSolution(int x) {
        int revertedNumber = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x /10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
