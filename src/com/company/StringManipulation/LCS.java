package com.company.StringManipulation;

import java.util.function.IntConsumer;

public class LCS {
    public static void main(String[] args){
        System.out.println(LCS("ABCE", "ABCDE"));
        String something = "abc";
        something.chars().forEach(value -> {

        });
    }

    static int LCS(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                if (x.charAt(i - 1) == y.charAt(j - 1)){
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else{
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }
        return table[m][n];
    }
}
