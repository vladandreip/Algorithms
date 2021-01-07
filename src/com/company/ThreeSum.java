package com.company;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numberArray = {-1,0,1,2,-1,-4};
        int[] fuckingShit = {-1,0,1,0};
        int[] iabadoo = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};


        //int[] numberArray2 = {3,0,-2,-1,1,2};
        //int[] numberArray3 = {-1, 0, 5, 1, 3, 5, 6, -2};
        //System.out.println(threeSum(numberArray));
        //System.out.println(threeSum(numberArray2));
        System.out.println(threeSum2(iabadoo));



    }
    //critical fail
    public static List<List<Integer>> threeSum(int[] nums) {
        //Arrays.sort(nums);
        Map<Integer, Integer> elementPosition = new HashMap<>();
        List<List<Integer>> solution = new ArrayList<>();
        int countZero = 0;

        if (nums.length < 3) return solution;

        for (int i = 0; i < nums.length; i++) {
            elementPosition.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int twoSum = nums[i] + nums[i + 1];
            if (elementPosition.containsKey(-twoSum)) {
                //if (i + 1 != elementPosition.get(-twoSum)) {
                System.out.println(elementPosition.get(-twoSum));
                    List<Integer> sortedTriplet = sortTriplet(nums[i], nums[i + 1], nums[elementPosition.get(-twoSum)]);
                    if (!(firstTwoElementsMap.containsKey(sortedTriplet.get(0)) && firstTwoElementsMap.get(sortedTriplet.get(0)).equals(sortedTriplet.get(1)))) {
                        solution.add(sortedTriplet);
                        System.out.println("HAU");
                        firstTwoElementsMap.put(sortedTriplet.get(0), sortedTriplet.get(1));
                    }
                //}
            }
        }

        return solution;
    }

    public static Map<Integer, Integer> firstTwoElementsMap = new HashMap<>();
    public static List<Integer> sortTriplet(int a, int b, int c) {
        List<Integer> triplet = new ArrayList<Integer>();
        if (a <= b) {
            if (c <= a) {
                triplet.add(c);
                triplet.add(a);
                triplet.add(b);
            } else if (c >= b) {
                triplet.add(a);
                triplet.add(b);
                triplet.add(c);
            } else {
                triplet.add(a);
                triplet.add(c);
                triplet.add(b);
            }


        } else {
            if (c <= b) {
                triplet.add(c);
                triplet.add(b);
                triplet.add(a);
            } else if (c >= a) {
                triplet.add(b);
                triplet.add(a);
                triplet.add(c);
            } else {
                triplet.add(b);
                triplet.add(c);
                triplet.add(a);
            }


        }
        return triplet;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int countZero = 0;
        List<List<Integer>> solution = new ArrayList<>();
        Map<Integer, Integer> elementPosition = new HashMap<>();
        Map<Integer, Integer> atLeastDouble = new HashMap<>();
        HashSet<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            if (elementPosition.containsKey(nums[i])) {
                atLeastDouble.put(nums[i], nums[i]);
            }
            elementPosition.put(nums[i], i);
        }

        System.out.println(atLeastDouble.containsKey(1));

        //[0, 0, 0]
        if (countZero > 2) triplets.add(Arrays.asList(0, 0, 0));

        if (nums.length < 3) return solution;


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++){
                int twoSum = nums[i] + nums[j];
                if (elementPosition.containsKey(-twoSum)) {
                    if (nums[i] == nums[elementPosition.get(-twoSum)] || nums[j] == nums[elementPosition.get(-twoSum)]) {
                        if (atLeastDouble.containsKey(nums[elementPosition.get(-twoSum)])) {
                            if (!(nums[i] == nums[j] && nums[i] == 0)) {
                                triplets.add(sortTriplet(nums[i], nums[j], nums[elementPosition.get(-twoSum)]));
                            }
                        }
                    } else {
                        triplets.add(sortTriplet(nums[i], nums[j], nums[elementPosition.get(-twoSum)]));
                    }
                }
            }
        }

        return new ArrayList<>(triplets);

    }
}
