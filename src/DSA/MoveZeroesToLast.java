package DSA;

import java.util.Arrays;

class Solution1 {
    public
    void moveZeroes(int[] nums) {
        int temp1, temp2;
        for (int i = 0, k = 0; i < nums.length && k < nums.length; i++) {
            if (nums[i] == 0) {
                temp1 = 0;
                for (int j = nums.length - 1; j >= i; j--) {
                    temp2 = nums[j];
                    nums[j] = temp1;
                    temp1 = temp2;
                }
                i = i-1;
            }
            k++;
            System.out.println(Arrays.toString(nums));
            System.out.println("k:"+k);
        }
    }

    public int removeDuplicates(int[] nums) {
        for(int i=0; i<nums.length;i++){
            if(nums[i] == nums[i+1])
            {
                int j = i+1;
                while(nums[i] == nums[j])
                {
                    nums[j] = Integer.MAX_VALUE;
                    j++;
                }
                i = j-1;
            }

        }

        Arrays.sort(nums);

        return nums;
    }
}

public class MoveZeroesToLast {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        s1.moveZeroes(new int[]{9,2,9,7,1,8,7,7,8,9,3,7,4,6,5,3,8,8,0,2,2,1,5,8,5,0,6,8,5,5,5,4,6,4,1,1,0,4,0,0,2,2,3,8,2,7,1,3});
    }
}


// input : [9,2,9,7,1,8,7,7,8,9,3,7,4,6,5,3,8,8,0,2,2,1,5,8,5,0,6,8,5,5,5,4,6,4,1,1,0,4,0,0,2,2,3,8,2,7,1,3]
// output :  9 2 9 7 1 8 7 7 8 9 3 7 4 6 5 3 8 8 2 2 1 5 8 5 6 8 5 5 5 4 6 4 1 1 0 4 0 0 2 2 3 8 2 7 1 3 0 0

// expected : 9 2 9 7 1 8 7 7 8 9 3 7 4 6 5 3 8 8 2 2 1 5 8 5 6 8 5 5 5 4 6 4 1 1 4 2 2 3 8 2 7 1 3 0 0 0 0 0

