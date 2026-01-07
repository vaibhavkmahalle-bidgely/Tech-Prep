package dsa.arrays;

import java.util.Arrays;

class Solution {
    public void rotateArray(int[] nums, int k) {
        int temp2, temp1;
        for (int i = 0; i < k; i++) {
            temp1 = nums[0];
            for (int j = nums.length - 1; j >= 0; j--) {
                temp2 = nums[j];
                nums[j] = temp1;
                temp1 = temp2;
            }
            System.out.println(Arrays.toString(nums));
        }

        System.out.println(Arrays.toString(nums));
    }
}

public class ArrayLeftRotation {
    public static void main(String[] args) {

        Solution s1 = new Solution();
        s1.rotateArray(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }
}
