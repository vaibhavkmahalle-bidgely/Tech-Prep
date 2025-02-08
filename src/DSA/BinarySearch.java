package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = (start + end) / 2;
        System.out.println("Initial end mid and start : end : " + end + ", mid : " + mid + ", start : " + start);

        while (end >= start) {
            System.out.println("Checking for mid : " + mid);
            if (nums[mid] == target) {
                System.out.println("Checking for mid : " + mid);
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
                mid = (start + end) / 2;
                System.out.println("end, mid and start is , end : " + end + ", mid : " + mid + ", start : " + start);

            } else if (nums[mid] > target) {
                end = mid - 1;
                mid = (start + end) / 2;
                System.out.println("end, mid and start is , end : " + end + ", mid : " + mid + ", start : " + start);
            }
        }
        return -1;
    }

    public static int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }

            if (nums[mid] < x) {
                low = mid + 1;
            }

        }

        return ans;
    }

    public static int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int getFloor(int[] nums, int x, int len) {
        int result = -1;
        int low = 0, high = len;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == x) {
                return x;
            }
            if (nums[mid] < x) {
                result = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int getCeil(int[] nums, int x, int len) {
        int result = -1;
        int low = 0, high = len;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == x) {
                result = x;
                System.out.println("Printing result1 : " + result);

                return result;
            }
            if (nums[mid] > x) {
                result = nums[mid];
                System.out.println("Printing result2 : " + result);
                high = mid - 1;
            }
            if (nums[mid] < x) {
                low = mid + 1;
            }
        }
        System.out.println("Printing result3 : " + result);
        return result;
    }

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int[] result = {-1, -1};
        int len = nums.length - 1;
        if (len == 0) {
            if (nums[0] == x) {
                result[0] = x;
                result[1] = x;
            }
            if (nums[0] < x) {
                result[0] = x;
                result[1] = -1;
            }
            if (nums[0] > x) {
                result[0] = -1;
                result[1] = x;
            }
            return result;
        }
        result[0] = getFloor(nums, x, len);
        result[1] = getCeil(nums, x, len);
        return result;
    }

    public static int[] getStart(int[] nums, int x, int len) {
        int low = 0, high = len - 1;
        int[] result = {-1, -1};

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == x) {
                int mid1 = mid - 1;
                int mid2 = mid + 1;
                while (mid1 >= 0 && nums[mid1] == x) {
                    mid1--;
                }
                while (mid2 < len && nums[mid2] == x) {
                    mid2++;
                }

                result[0] = mid1 + 1;
                result[1] = mid2 - 1;
                return result;
            }
            if (nums[mid] > x) {
                high = mid - 1;
            }
            if (nums[mid] < x) {
                low = mid + 1;
            }

        }
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        int len = nums.length;

        if (len == 1) {
            if (nums[0] == target) {
                range[0] = 0;
                range[1] = 0;
            } else {
                range[0] = -1;
                range[1] = -1;
            }
            return range;
        }

        range = getStart(nums, target, len);
        return range;


    }

    public static boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {

        int low = 0, high = nums.size() - 1, target = k;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == k) return true;
            if (nums.get(low) < nums.get(mid)) {
                System.out.println("Left subarray is sorted : ");
                if (nums.get(low) <= target && target < nums.get(mid)) {
                    high = mid - 1;
                    System.out.println("left high : " + high);
                } else {
                    low = mid + 1;
                    System.out.println("left low : " + low);
                }
            } else if (nums.get(low) >= nums.get(mid)) {
                if (nums.get(mid) < target && target <= nums.get(high)) {
                    low = mid + 1;
                    System.out.println("right low : " + low);
                } else {
                    high = mid - 1;
                    System.out.println("right high : " + high);
                }
            }
        }
        return false;
    }

    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length, ans = 0;
        if (len == 1) return nums[0];

        for(int i=0 ; i<len; i++){
            ans ^=  nums[i];
            System.out.println("answer with each iteration : " + ans);
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] nums = {-9368,-5249,-4316,-3752,-3005,-1788,-1603,-1381,-99,987,3161,3447,4889,4970,4977,5665,7214,8501,8611,9032};
//        int[] nums1 = {3,5,8,15,19};
//        int[] nums2 = {505, 664};
//        int[] nums3 = {-20,-20,-20,-20};
//
//       int result =  search(nums, 3161);
//
//       int result1 = upperBound(nums1, 9);
//
//       int[] result2 = getFloorAndCeil(nums2, 118);
//
//       int[] result3 = searchRange(nums3,-20);
//
//        System.out.println("Floor and ceiling are : " + Arrays.toString(result2));
//
//        System.out.println("First and Last occurence of target : " + Arrays.toString(result3));
//        System.out.println("The result of the index is this : "+ result);
//        System.out.println("Upperbound : " + result1);
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(3);
        nums.add(3);

        System.out.println(searchInARotatedSortedArrayII(nums, 1));

        int[] numss = {1,1,2,3,3,4,4,5,5,6,6,7,7};
        System.out.println(singleNonDuplicate(numss));


    }
}
