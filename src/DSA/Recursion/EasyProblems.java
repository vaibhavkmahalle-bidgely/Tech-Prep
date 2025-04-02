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

    public static void mergeList(ArrayList<Integer> nums, Integer f){
        // base condition
        if(nums.size() == 0 || nums.get(nums.size()-1) <= f){
            nums.add(f);
            return;
        }

        Integer f1 = nums.remove(nums.size()-1);
        mergeList(nums,f);

        nums.add(f1);

    }

    public static void sortList(ArrayList<Integer> nums){
        // base condition
        if(nums.size() == 1){
            return;
        }

        Integer f = nums.remove(0);
        System.out.println("nums : " + nums);
        sortList(nums);
        System.out.println("sortedNums : " + nums);
        mergeList(nums, f);

    }


    public static boolean isSorted(ArrayList<Integer> nums) {
        ArrayList<Integer> temp = new ArrayList<>(nums);

        sortList(temp);

        System.out.println(temp);

        return temp.equals(nums);
    }



    public static void main(String[] args) {
        // print1toN(5);
        int[] arr = {1, 2, 3, 4, 5};
        //1,9,6,8,5,4,0

        ArrayList<Integer> input = new ArrayList<>();

        input.add(1);
        input.add(9);
        input.add(6);
        input.add(8);
        input.add(5);
        input.add(4);
        input.add(0);


        System.out.println(isSorted(input));
    }

//    public Vector<Character> reverseString(Vector<Character> s) {
//        // Hypothesis :
//        // reverseString(s) -> this function will give me an array of reversedString of size s.length
//        // reverseString(s-1) -> this function should give me an array of reversedString of size s.length-1
//
//
//        // Induction : for Hypothesis to be true, we have to write code here now
//
//        Vector<Character> ans = new Vector<>();
//
//        ans = reverseString(new Vector<>(1, s.size()));
//        ans.add(s.get(0));
//        return ans;
//    }






}
