package leetcode.practice;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

import java.util.Arrays;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i+1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i,j};
        }
      }
    }
    return new int[] {0,0};
  }

  public static void main(String[] args) {
    int [] nums = new int[] {3,2,4};
    int target = 6;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }
}
