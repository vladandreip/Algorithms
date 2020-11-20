package com.company.StringManipulation;

public class SpecialString {
    public static void main(String[] args){
        String s = "aaaa";
        System.out.println(substrCount(s.length(), s));
    }

    static long substrCount(int n, String s) {
        int count = n;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n ; j++)
                if (isSpecial(s.substring(i, j + 1))) {
                    count++;
                    System.out.println(s.substring(i, j + 1));
                }
        }
        return count;
    }

    static boolean isSpecial(String s){
        int size = s.length();
        boolean test = true;
        for (int i = 0; i < size / 2 ; i++)
            if ((s.charAt(i) != s.charAt(size - 1 - i) || s.charAt(i) != s.charAt(0))) {
                test = false;
                break;
            }
        return test;
    }


}
