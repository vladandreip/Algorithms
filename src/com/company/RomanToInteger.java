package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("XX"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> valueMap = new HashMap<>();

        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            result += valueMap.get(s.charAt(i));
        }

        return result;
    }
}
