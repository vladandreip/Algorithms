package com.company.RecursionPractice;
//1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3,
//possible expressions are ((())), ()(()), ()()(), (())(), (()()).
public class CatalanNumber {
    public static void main(String[] args){
        int n = 19;
        System.out.println(catalanNumber(n));
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        System.out.println(dynamicCatalan(n, catalan));
        System.out.println(dynamicCatalan2(n));
    }

    //recursive
    public static int catalanNumber(int n) {
        int sum = 0;
        if (n <= 1) return 1;
        for (int i = 0; i < n; i++){
            sum = sum + catalanNumber(i) * catalanNumber(n - i - 1);
        }
        return sum;
    }

    //dynamic top-bottom
    public static int dynamicCatalan(int n, int[] catalan){
        if (catalan[n] == 0){
            for (int i = 0; i < n; i++){
                catalan[n] += dynamicCatalan(i, catalan) * dynamicCatalan(n - i - 1, catalan);
            }
        }
        return catalan[n];
    }

    //dynamic bottom-top
    public static int dynamicCatalan2(int n){
        int[] catalan = new int[n + 2];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < i; j++){
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

}
