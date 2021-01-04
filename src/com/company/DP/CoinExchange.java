package com.company.DP;

import java.util.Arrays;

public class CoinExchange {

    public static void main(String[] args) {
        int array[] = {186, 419, 83, 408};
        //Arrays.sort(array);

        //System.out.println("Cacat" + coinChange(array, 6249));

        int array2[] = {1, 2, 5, 6};
        System.out.println("Solutia: " + coinChange2(array2, 11));
        System.out.println("Solutia: " + coinChange2(array, 6249));
    }

    //version 1
    public static int coinChange(int[] coins, int amount) {
        int i = coins.length - 1;
        int minimumCoins = Integer.MAX_VALUE;
        int coinNumber = 0;
        int rest;
        while (i >= 0) {
            rest = amount;
            coinNumber = 0;
            for (int j = i; j >= 0; j--) {
                if (rest / coins[j] > 0) {
                    coinNumber += rest / coins[j];
                    rest = rest - coins[j] * (rest / coins[j]);

                }
            }
            if (coinNumber < minimumCoins && rest == 0) {
                minimumCoins = coinNumber;
            }
            i--;
        }

        if (minimumCoins == Integer.MAX_VALUE) {
            return -1;
        }
        return minimumCoins;
    }

    /**
     * Computes an array(0 to amount) holding minimum number of coins to sum the position
     * Example: given amount 10 and coins {1 ,2 5} -> minimumSolution[0] = 0, minimumSolution[1] = 1, minimumSolution[2] = 1, minimumSolution[3] = 2 (1  + 2)
     * Bottom-UP solution - DP
     */
    public static int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] minimumSolution = new int[max];

        Arrays.fill(minimumSolution, max);

        minimumSolution[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    //1 because minimumSolution[coin] = 1
                    minimumSolution[i] = Math.min(minimumSolution[i], 1 + minimumSolution[i - coin]);
                }
            }
        }

        return minimumSolution[amount] > amount ? -1 : minimumSolution[amount];
    }
}
