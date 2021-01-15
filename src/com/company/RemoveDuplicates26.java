package com.company;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 */
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        //int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] a = new int[]{1 ,1, 2, 2};
        System.out.println(removeDuplicates3(a));


    }

    /**
     *First working solution. Overly complicated not achieved optimisation -> faster than 5%
     */
    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        int duplicate;
        int startPosition;
        int endPosition;
        int resizeWith = 0;
        if (nums.length <= 1) return nums.length;
        while (i < nums.length - resizeWith ) {
            if ((i + 1) < nums.length && nums[i] == nums[i + 1]){
                startPosition = i;
                while ((i + 1 < nums.length - resizeWith) && nums[i] == nums[i + 1]) {
                    i++;
                }
                endPosition = i;
                duplicate = endPosition - startPosition;

                for(int j = startPosition + 1; j < startPosition + 1 + (nums.length - endPosition - 1); j++) {
                    nums[j] = nums[j + duplicate];
                }

                while (duplicate > 0) {
                    resizeWith++;
                    duplicate --;
                }

                i = startPosition;

            }
            i++;
        }


        if (nums.length - resizeWith < nums.length) {
            nums = Arrays.copyOf(nums, nums.length - resizeWith);
        }

        System.out.println(Arrays.toString(nums));

        return nums.length;
    }

    /**
     * This is working here in the IDE, but compiler doesn't accept the solution
     */
    public static void removeDuplicates(int[] nums) {
        HashSet<Integer> numbers = new HashSet();

        for(int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }

        Object[] hashToArray = numbers.toArray();
        int size = numbers.toArray().length;
        for (int i = 0; i < size; i++) {
            nums[i] = (Integer) hashToArray[i];
        }
        nums = Arrays.copyOf(nums, size);

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void removeDuplicates2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

    }

    /**
     *Hit my face after realised how simple was to get the best results -> faster than 100% of the submissions
     */
    public static int removeDuplicates3(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int value = nums[0];
        int i = 1;
        int position = 1;
        while(i < nums.length) {
            if(nums[i] != value) {
                nums[position] = nums[i];
                position++;
                value = nums[i];
            }
            i++;
        }

        nums = Arrays.copyOf(nums, position);

        return nums.length;
    }
}
