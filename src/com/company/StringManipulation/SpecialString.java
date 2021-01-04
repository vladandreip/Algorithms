package com.company.StringManipulation;
//GFG
public class SpecialString {
    public static void main(String[] args){
        String s = "aadaa";
        //System.out.println(solution1(s.length(), s));
        System.out.println(solution2(s.length(), s));
    }

    static long solution1(int n, String s) {
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

    static long solution2(int n, String s) {
        boolean isSpecial;
        int i = 0;
        int k;
        int j = 0;
        int pos;
        int specialCount = 0;
        int posT, sizeT;
        while(j < n - 1) {
            i = j;
            while (i < n - 1) {
                System.out.println(i);
                if (s.charAt(i) == s.charAt(i + 1)) {
                    specialCount++;
                    i++;
                } else {
                    pos = i + 1;
                    posT = pos - j;
                    sizeT = n - j;
                    if (posT <= sizeT - (posT + 1)) {
                        k = 0;
                        isSpecial = true;
                        while (k < posT) {
                            if (s.charAt(pos) != s.charAt(pos + k)) {
                                isSpecial = false;
                                break;
                            }
                            k++;
                        }
                        if (isSpecial) {
                            specialCount++;
                        }
                    } else {
                        j++;
                        break;
                    }
                    i++;
                }
            }
            j++;
        }
        return specialCount + n;
    }
}
