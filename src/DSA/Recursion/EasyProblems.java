package DSA.Recursion;

import java.util.*;
import java.util.stream.IntStream;

public class EasyProblems {
    // print 1 to n

    public static void print1toN(int n) {
        if (n == 0)
            return;
        print1toN(n - 1);
        System.out.print(n + ",");
    }

    public static List<Integer> mergeLast(List<Integer> nums, Integer f){
        List<Integer> merged = new ArrayList<>();
        int i = 0;

        // output f
        System.out.println(" f int mergeLast : "+ f);
        System.out.println("sorted in mergeLast" + nums);

        // Merge f into the correct position in the sorted list
        while (i < nums.size() && nums.get(i) < f) {
            merged.add(nums.get(i));
            i++;
        }

        // Add f at the correct position
        merged.add(f);

        // Add the remaining elements
        while (i < nums.size()) {
            merged.add(nums.get(i));
            i++;
        }

        System.out.println("Merged result: " + merged);
        return merged;
    }

    public static List<Integer> getSortedArray(List<Integer> nums) {
        // 1,9,6,8,5,4,0

        // Hypothesis :
        // getSortedArray(1,9,6,8,5,4,0) -> tar mala sorted output bhetil
        // getSortedArray(9,6,8,5,4,0) -> tar mala ya input sathi sorted output bhetil

        // 1 ch kay hoeel
        // Induction :
        // 1 aplyale rest of the list sobat merge karav lagel.
        // kasa -> function lihun

        // base condition

        if(nums.size() == 1){
            return new ArrayList<>(nums);
        }

        List<Integer> sortedList = getSortedArray(new ArrayList<>(nums.subList(1,nums.size())));

       sortedList = mergeLast(sortedList,nums.get(0));
        System.out.println(sortedList);

        return sortedList;

    }

    public static boolean isSorted(List<Integer> nums) {
        // your code goes here
        // getA sorted array using recursion
        // compare two arrays.

        List<Integer> sortedNums = getSortedArray(nums);

        if (sortedNums.equals(nums)) return true;
        else return false;
    }



    public static void main(String[] args) {
        // print1toN(5);
        int[] arr = {1, 2, 3, 4, 5};
        //1,9,6,8,5,4,0

        List<Integer> input = new ArrayList<>();

        input.add(1);
        input.add(9);
        input.add(6);
        input.add(8);
        input.add(5);
        input.add(4);
        input.add(0);


        System.out.println(Arrays.toString(reverseArray(arr)));

        System.out.println(isSorted(input));
    }

    public Vector<Character> reverseString(Vector<Character> s) {
        // Hypothesis :
        // reverseString(s) -> this function will give me an array of reversedString of size s.length
        // reverseString(s-1) -> this function should give me an array of reversedString of size s.length-1


        // Induction : for Hypothesis to be true, we have to write code here now

        Vector<Character> ans = new Vector<>();

        ans = reverseString(new Vector<>(1, s.size()));
        ans.add(s.get(0));
        return ans;
    }

    public static int[] reverseArray(int[] nums) {
        // Hypothesis :
        // reversArray(nums) -> ye muze nums array reverse krke dega
        // reverseArray(nums-1) -> ye muze nums-1 elements reverse krke dega

        // Induction :
        // Hypothesis true krne ke liye muze code likhna hai

        // Base Condition : smallest valid input - array with 1 element - wo already reversed hai so return same
        int[] ans = new int[10];
        if (nums.length == 1)
            return nums;
        System.out.println("call");
        ans = reverseArray(Arrays.stream(nums, 1, nums.length).toArray());
        ans[ans.length - 1] = nums[0];
        return ans;
    }




}
