//package DSA;
//
//import java.util.Arrays;
//
//public class MergeSort {
//    public static int[] mergeSortAlgo(int[] nums){
//
//        int n = nums.length;
//        if(n == 1) return nums;
//
//        int mid = n/2;
//        int[] left ;
//        int[] right;
//
//        if(n%2 == 0){
//             left = new int[mid];
//            right = new int[mid];
//        }
//        else{
//            left = new int[mid+1];
//            right = new int[mid];
//        }
//        if(n == 2){
//            if(nums [0] > nums[1]){
//                right[0] = nums[0];
//                left[0] = nums[1];
//
//            }
//            else{
//                right[0] = nums[1];
//                left[0] = nums[0];
//            }
//        }
//
//        int i =0;
//        int j=0;
//        if(n > 2){
//            for(int element : nums){
//                if(element > nums[mid]){
//                    right[i] = element;
//                    i++;
//                }else{
//                    left[j] = element;
//                    j++;
//                }
//            }
//        }
//
//
//        System.out.println("left array : " + Arrays.toString(left));
//        System.out.println("right array : " + Arrays.toString(right));
//
//        left = mergeSortAlgo(left);
//        right = mergeSortAlgo(right);
//        nums = merge(left, right);
//
//
//        return nums;
//    }
//
//    public static int[] merge(int[] n1, int[] n2){
//        int[] resultArray = new int[n1.length+n2.length];
//
//        for()
//        return n1;
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
//        System.out.println("Sorted array using merge sort : " + Arrays.toString(mergeSortAlgo(nums)));
//    }
//}
//
//
//
///*
//class Solution {
//    // Function to merge two sorted halves of the array
//    public void merge(int[] arr, int low, int mid, int high) {
//        // Temporary array to store merged elements
//        List<Integer> temp = new ArrayList<>();
//        int left = low;
//        int right = mid + 1;
//
//        // Loop until subarrays are exhausted
//        while (left <= mid && right <= high) {
//            // Compare left and right elements
//            if (arr[left] <= arr[right]) {
//                // Add left element to temp
//                temp.add(arr[left]);
//                // Move left pointer
//                left++;
//            } else {
//                // Add right element to temp
//                temp.add(arr[right]);
//                // Move right pointer
//                right++;
//            }
//        }
//
//        // Adding the remaining elements of left half
//        while (left <= mid) {
//            temp.add(arr[left]);
//            left++;
//        }
//
//        // Adding the remaining elements of right half
//        while (right <= high) {
//            temp.add(arr[right]);
//            right++;
//        }
//
//        // Transferring the sorted elements to arr
//        for (int i = low; i <= high; i++) {
//            arr[i] = temp.get(i - low);
//        }
//    }
//
//    // Helper function to perform merge sort from low to high
//    public void mergeSortHelper(int[] arr, int low, int high) {
//        // Base case: if the array has only one element
//        if (low >= high)
//            return;
//
//        // Find the middle index
//        int mid = (low + high) / 2;
//        // Recursively sort the left half
//        mergeSortHelper(arr, low, mid);
//        // Recursively sort the right half
//        mergeSortHelper(arr, mid + 1, high);
//        // Merge the sorted halves
//        merge(arr, low, mid, high);
//    }
//
//    // Function to perform merge sort on the given array
//    public int[] mergeSort(int[] nums) {
//        int n = nums.length; // Size of array
//
//        // Perform Merge sort on the whole array
//        mergeSortHelper(nums, 0, n - 1);
//
//        // Return the sorted array
//        return nums;
//    }
//}
//*/