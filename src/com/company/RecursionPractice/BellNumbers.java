package com.company.RecursionPractice;
//Given a set of n elements, find number of ways of partitioning it.
/* set: {1,2,3}
{ {1}, {2}, {3} }
             { {1}, {2, 3} }
             { {2}, {1, 3} }
             { {3}, {1, 2} }
             { {1, 2, 3} }.
 */
public class BellNumbers {
    public static void main(String[] args){
        int n = 4;
        System.out.println(recursiveBell(n,n));
    }

    public static int recursiveBell(int n, int k){
        if (n == 0 || k == 0 || k > n)
            return 1;
        if (k == 1 || n == 1)
            return 1;
        return (k * recursiveBell(n - 1, k) + recursiveBell(n - 1, k - 1));
    }

}
