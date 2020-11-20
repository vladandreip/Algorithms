package com.company.RecursionPractice;

public class Fibonacci {
    public static void main(String[] args){
        fib(5);
        int n = 5;
        System.out.println("-------------------------------------- DYNAMIC ------------------------------------");
        System.out.println(fiboDin(n, new int[n + 1]));
    }
    static int i = 0;

    public static int fib(int n) {
        i++;
        System.out.println("call " + i + " n is: " + n);

        if(n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int a = fib(n-2) + fib(n-1);

        //System.out.println("value is: " + a);

        return a;
    }

    static int j = 0;
    static int fiboDin(int n, int[] memo) {
        j++;
        System.out.println("call " + j + " n is: " + n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == 0) memo[n] = fiboDin(n-1, memo) + fiboDin(n-2, memo);
        return memo[n];
    }
}
