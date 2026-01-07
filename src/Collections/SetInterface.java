package collections;

import java.util.*;
import java.util.LinkedHashSet;

public class SetInterface {
    /*
        Set is a child interface of Collection interface
        Duplicates are not allowed
        Insertion order is not preserved
        Set Interface does not contain any new method

    * */

    /*
        HashSet :
        Hash Table is the data structure.
        If you try to insert the duplicate object, method simply returns false, as duplicates are not allowed.
        Insertion order is not preserved but all object are inserted based on hash code.
        Heterogeneous objects are allowed.
        Null values are allowed.
        Provide efficient searching.

        Constructors in HashSet :
        HashSet()                                       -  default capacity 16, load factor = 0.75
        HashSet(int capacity)                           -  load factor - 0.75
        HashSet(int capacity, float loadFactor)
        HashSet(Collection c)
    */

    /*
        LinkedHashSet :
        Child class of Hash Set.
        Insertion order is preserved unlike HashSet
        Hash Table and Doubly Linked List both are used (hybrid DS)

        Constructors In LinkedHashSet :

        LinkedHashSet()                                         - Default 16, loadFactor - 0.75
        LinkedHashSet(int capacity)
        LinkedHashSet(int capacity, float loadFactor)
        LinkedHashSet(Collection c)
    */

    /*Problems to Practice using these :
     * Problem: Given an array of integers, remove duplicates and print the unique elements.
     * Problem: Check whether a string contains duplicate characters.
     * Problem: Given two arrays, find their union and intersection using sets.
     * Problem: Find the first non-repeating character in a string.
     * Problem: Implement a basic Least Recently Used (LRU) Cache using LinkedHashSet.

     * */

    // Declare method that will take array as an input and remove duplicates and return the modified array

    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> lset = new LinkedHashSet<>(array.length);

        for (int element : array) {
            lset.add(element);
        }

        int index = 0;
        int[] result = new int[lset.size()];
        for (Object element : lset) {
            result[index++] = (int) element;
        }

        System.out.println("lset me kya hai " + lset);
        return result;
    }

    // check whether string contains duplicate character :
    public static String isDuplicate(String exampleString) {
        HashSet<Character> hset = new HashSet<>(exampleString.length());
         exampleString=exampleString.toLowerCase();

        for (int i = 0; i < exampleString.length(); i++) {
            hset.add(exampleString.charAt(i));
        }
        if (hset.size() != exampleString.length())
            return "String contains duplicates";
        else
            return "String does not contain duplicates";
    }

    public static int[] findUnion(int[] array1, int[] array2){
        LinkedHashSet<Integer> lset = new LinkedHashSet<>(array1.length+array2.length);

        for (int element : array1){
            lset.add(element);
        }

        for (int element : array2)
        {
            lset.add(element);
        }

        int[] resultArray = new int[lset.size()];
        int index = 0;

        for (int element : lset){
            resultArray[index++] = element;
        }
        return resultArray;
    }

    public static int[] findIntersection(int[] array1, int[] array2){
        LinkedHashSet<Integer> lset = new LinkedHashSet<>(array1.length + array2.length);
        LinkedHashSet<Integer> lset1 = new LinkedHashSet<>(array2.length);
        for(int element : array1){
            lset.add(element);
        }

        for(int element : array2){
            if(!lset.add(element)){
                lset1.add(element);
            }
        }

        int [] resultArray = new int[lset1.size()];
        int index = 0;
        for(int element : lset1){
            resultArray[index++] = element;
        }


        return resultArray;
    }

    public static Character nonRepeatingCharacter(String inputString){
        LinkedHashSet<Character> lset = new LinkedHashSet<>(inputString.length());
        LinkedHashSet<Character> lset1 = new LinkedHashSet<>(inputString.length());

        for(int i=0; i< inputString.length(); i++){
            if(!lset.add(inputString.charAt(i))){
                lset1.add(inputString.charAt(i));
            }
        }

        System.out.println("lset and lset1 have : "+ lset + " "+ lset1);
        for(Character el : lset){
            if(!lset1.contains(el)){
                return (char)el;
            }
        }



        return null;
    }



    public static void main(String[] args) {
        // Initialize an array of size 8 with duplicate elements.

        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 6, 7
        };

        System.out.println("Calling removeduplicates : " + Arrays.toString(removeDuplicates(nums)));

        System.out.println("Checking if string contains duplicates : " + isDuplicate("VAibhav"));

        int[] nums1 = new int[]{1,1,2,2,3,4,5};
        int[] nums2 = new int[]{1,2,2,3,4,5,6};

        System.out.println("Union of two Array : " + Arrays.toString(findUnion(nums1,nums2)));
        System.out.println("Intersection of two Array : " + Arrays.toString(findIntersection(nums1,nums2)));

        System.out.println("NonRepeating character : " + nonRepeatingCharacter("astaggfirullahst"));


    }

}
