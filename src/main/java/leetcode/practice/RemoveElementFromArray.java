package leetcode.practice;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
*/
public class RemoveElementFromArray {
  public static int removeElement (int [] nums, int val) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[j] = nums[i];
        j++;
      }
    }
    return j;
  }

  public static void main(String[] args) {
    System.out.println(removeElement(new int[] {3,2,2,3}, 3));
    System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
  }
}
