package com.company;

import java.util.Arrays;

//12
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman2(24));
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < symbols.length; i++) {
            int numberOfSymbols = num / values[i];
            if (numberOfSymbols > 0) {
                num = num - (num / values[i]) * values[i];
                while(numberOfSymbols > 0){
                    //result += symbols[i];
                    stringBuilder.append(symbols[i]);
                    numberOfSymbols--;
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     *Nice optimization idea -> symbols on even positions are formed [i][i-1] -> CM = [i](C)[i-1][M]
     */

    public static String intToRoman2(int num) {

        //String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        char[] symbols = new char[]      {'M', 'C', 'D', 'C', 'C', 'X', 'L', 'X', 'X', 'I', 'V', 'I', 'I'};
        char[] result = new char[19];
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < symbols.length; i++) {
            int numberOfSymbols = num / values[i];
            if (numberOfSymbols > 0) {
                if (i % 2 != 0) {
                    num = num - (num / values[i]) * values[i];
                    while (numberOfSymbols > 0) {
                        result[i] = symbols[i];
                        numberOfSymbols--;
                    }
                } else {
                    result[i] = symbols[i];
                    result[i+1] = symbols[i - 1];
                }
            }
        }
        return Arrays.toString(result);
    }
}
