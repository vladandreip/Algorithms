package com.company;

public class ReversedInteger {
    /**
     *
     * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
    public static void main(String[] args) {
        //System.out.println(reverse(1463847412));
        System.out.println(reverse(-11));
        System.out.println(reverse(-2143847413));


    }

    public static int reverse(int x) {
        int nineDivisions = 9;
        int reverse = 0;
        boolean negative = false;

        if (x < 0) {
            x = -x;
            negative = true;
        }

        while (x > 0 && nineDivisions > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
            nineDivisions--;
        }

        if (nineDivisions == 0 && x > 0) {
            if (Integer.MAX_VALUE / 10 == reverse) {
                if (x < 9) {
                    reverse = reverse * 10 + x % 10;
                } else {
                    return 0;
                }
            } else if (Integer.MAX_VALUE / 10 > reverse) {
                reverse = reverse * 10 + x % 10;
            } else {
                return 0;
            }
        }

        return negative ? -reverse:reverse;
    }
}
