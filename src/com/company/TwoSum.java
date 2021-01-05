package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSums3(nums, target)));

    }

    /**
     * First solution -> goes throw n Log(n)
     * Although the compiler marks this as te fastest from all -> it's not
     */
    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> expectedSummer = new ArrayList<Integer>();
        int[] positions = new int[2];
        boolean flag = false;
        expectedSummer.add(target - nums[0]);
        positions[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            System.out.println(i);
            for (int j = 0; j < expectedSummer.size(); j++) {
                if (expectedSummer.get(j) == nums[i]) {
                    positions[0] = j;
                    positions[1] = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                expectedSummer.add(target - nums[i]);
            }
        }
        return positions;
    }

    /**
     * Tried to optimize first solution -> ended up with a crap
     */
    public static int[] twoSums2(int[] nums, int target) {
        int[] positions = new int[2];

        HashMap<Integer, Integer> positionDifference = new HashMap<>();
        HashMap<Integer, Integer> elementPosition = new HashMap<>();
        HashMap<Integer, Integer> doubleElementSum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            positionDifference.put(i, target - nums[i]);
            if (elementPosition.get(nums[i]) != null) {
                doubleElementSum.put(nums[i] * 2, i);
            } else {
                elementPosition.put(nums[i], i);
            }

        }

        if (doubleElementSum.get(target) == null) {

            for (int i = 0; i < nums.length; i++) {
                if (elementPosition.get(positionDifference.get(i)) != null) {
                    positions[0] = i;
                    positions[1] = elementPosition.get(positionDifference.get(i));
                    if (positions[0] != positions[1]) {
                        break;
                    }
                }
            }
        } else {
            positions[0] = elementPosition.get(target / 2);
            positions[1] = doubleElementSum.get(target);
        }
        return positions;
    }

    /**
     *Best solution from the 3 -> O(n). After optimizing second crappy solution
     *After some time I realised how dead simple it was
     * */
    public static int[] twoSums3(int[] nums, int target) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            elements.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (elements.containsKey(complement) && elements.get(complement) != i) {
                return new int[] {i, elements.get(complement)};
            }
        }
        throw new IllegalArgumentException();
    }
}
