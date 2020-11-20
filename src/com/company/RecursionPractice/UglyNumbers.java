package com.company.RecursionPractice;
//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
//shows the first 11 ugly numbers. By convention, 1 is included.
//Given a number n, the task is to find n’th Ugly number.
public class UglyNumbers {
    public static void main(String[] args){
        System.out.println(uglyNumber(150));
        System.out.println(dynamicUgly(150));
    }
    //iterative version
    static boolean isUgly(int number){
        while (number % 2 == 0) number = number / 2;
        while (number % 3 == 0) number = number / 3;
        while (number % 5 == 0) number = number / 5;
        return number == 1;

    }

    static int uglyNumber(int n) {
        int count = 1;
        int contestNumber = 2;
        while(count < n){
            if(isUgly(contestNumber)){
                count++;
            }
            contestNumber++;
        }
        return contestNumber - 1;
    }

    ////////////////////////////dynamic programming////////////////////////////////////////

    static int dynamicUgly(int n){
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        int[] uglyNumbers = new int[n + 1];
        uglyNumbers[0] = 1;
        int nextUglyNumber = 2;
        for (int i=1; i<n; i++){
            uglyNumbers[i] = Math.min(Math.min(2 * uglyNumbers[index_2], 3 * uglyNumbers[index_3]), 5 * uglyNumbers[index_5]);
            if (nextUglyNumber == uglyNumbers[index_2] * 2) index_2++;
            if (nextUglyNumber == uglyNumbers[index_3] * 3) index_3++;
            if (nextUglyNumber == uglyNumbers[index_5] * 5) index_5++;
            nextUglyNumber = Math.min(Math.min(2 * uglyNumbers[index_2], 3 * uglyNumbers[index_3]), 5 * uglyNumbers[index_5]);
        }

        return uglyNumbers[n-1];
    }
}
