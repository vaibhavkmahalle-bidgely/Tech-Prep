package Collections;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class LearnSortedSet {
    /*
        Sorted Set :
        Sorted Set is a child interface of Set interface
        Duplicates are not allowed
        Elements are in sorted order - This is different than insertion order
        SortedSet interface introduces 6 new methods

        The main difference between Set and Sorted Set is
        In Set order is not important
        In Sorted Set order is important (some logical order like alphabetical order)

        Methods of SortedSet :
        first()                     -   Returns the first element of the set
        last()                      -   Returns the last element of the set
        headSet(E toElement)        -   Returns the view of the portion of this set whose elements are strictly less than toElement
        tailSet(E fromElement)      -   Returns the view of the portion of this set whose elements are greater than or equal to from Element.

    */

    /*
        Navigable Set :
        Child interface of SortedSet
        Provide methods for navigation in sorted list of elements

        Methods :
        ceiling(E e) - returns the least element in this set greater than or equal to the given element, or null if there is no such element
        floor(E e)   - Returns the greatest element in this set less than or equal to given element, or null if there is no such element
        higher(E e)  - Returns the least element in this set strictly greater than given element , or null if there is no such element
        lower(E e)   - Returns the greatest element in this set strictly less than given element, or null if there is no such element.
        pollFirst()  - Retrieves and removes the first(lowest) element , or returns null if the set is empty
        pollLast()   - Retrieves and removes the last(highest) element , or returns null if the set is empty
    */

    /*
            1. Find the Smallest and Largest Element
            Problem: Given a set of integers, find the smallest and largest elements using SortedSet.
            Methods to Use: first(), last()
            Example Input: {5, 3, 9, 1, 7}
            Expected Output:
            Smallest: 1
            Largest: 9


            2. Subset Extraction
            Problem: Given a set of strings in alphabetical order, find all strings that are lexicographically smaller than a given string.
            Methods to Use: headSet(E toElement)
            Example Input:
            Set: {"apple", "banana", "cherry", "date", "fig"}
            Target: "cherry"
            Expected Output: ["apple", "banana"]


            3. Extract Tail of the Set
            Problem: Given a set of integers, extract all elements greater than or equal to a specified value.
            Methods to Use: tailSet(E fromElement)
            Example Input:
            Set: {1, 3, 5, 7, 9}
            Target: 5
            Expected Output: [5, 7, 9]


            4. Range Query in a Set
            Problem: Given a set of numbers, extract all elements within a specified range (inclusive of the start but exclusive of the end).
            Methods to Use: subSet(E fromElement, E toElement)
            Example Input:
            Set: {10, 20, 30, 40, 50}
            Range: 20 to 40
            Expected Output: [20, 30]



            5. Find Next Largest Element
            Problem: Given a set of integers, find the smallest element that is larger than a given number.
            Methods to Use: tailSet(E fromElement)
            Example Input:
            Set: {10, 15, 20, 25, 30}
            Target: 18
            Expected Output: 20


            6. Remove Elements Outside a Range
            Problem: Given a set of integers, remove all elements outside a specific range (inclusive).
            Methods to Use: subSet(E fromElement, E toElement), clear(), addAll()
            Example Input:
            Set: {1, 2, 3, 4, 5, 6, 7}
            Range: 3 to 6
            Expected Output: {3, 4, 5, 6}


            7. Find Closest Elements
            Problem: Given a sorted set of numbers and a target number, find the closest smaller and larger elements.
            Methods to Use: headSet(E toElement), tailSet(E fromElement)
            Example Input:
            Set: {1, 3, 5, 7, 9}
            Target: 6
            Expected Output:
            Closest Smaller: 5
            Closest Larger: 7


            8. Maintain Sorted Order While Inserting
            Problem: Insert a list of numbers into a SortedSet and verify that the set maintains sorted order.
            Methods to Use: addAll(Collection<? extends E>)
            Example Input: {5, 1, 3, 9, 7}
            Expected Output: {1, 3, 5, 7, 9}


            9. Merge Two Sorted Sets
            Problem: Given two SortedSet objects, merge them into a single sorted set without duplicates.
            Methods to Use: addAll(Collection<? extends E>)
            Example Input:
            Set 1: {1, 3, 5}
            Set 2: {2, 4, 6}
            Expected Output: {1, 2, 3, 4, 5, 6}


            10. Count Elements in a Range
            Problem: Given a set of integers, count how many elements fall within a specified range (inclusive of both boundaries).
            Methods to Use: subSet(E fromElement, E toElement)
            Example Input:
            Set: {1, 2, 3, 4, 5, 6}
            Range: 2 to 5
            Expected Output: 4


            11. Find Median Element
            Problem: Find the median of a SortedSet. If the set has an even number of elements, return the average of the two middle elements.
            Methods to Use: Iteration with iterator()
            Example Input: {10, 20, 30, 40, 50}
            Expected Output: 30


            12. Reverse a SortedSet
            Problem: Reverse the order of elements in a SortedSet.
            Methods to Use: descendingSet()
            Example Input: {1, 2, 3, 4, 5}
            Expected Output: {5, 4, 3, 2, 1}

    */

    public static int getLargest(TreeSet<Integer> t) {
        int largest = t.last();
        return largest;
    }

    public static int getSmallest(TreeSet<Integer> t) {
        int smallest = t.first();
        return smallest;
    }

    public static void main(String[] args) {

        // problem 1
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < 9; i++) {
            t.add(i);
        }

        System.out.println("Entries in sorted set : " + t);
        System.out.println("Smallest number in Sorted Set : " + getSmallest(t));
        System.out.println("Largest number in Sorted Set : " + getLargest(t));

        // problem 2 and 3
        // {"apple", "banana", "cherry", "date", "fig"}
        TreeSet<String> t1 = new TreeSet<>();
        t1.add("apple");
        t1.add("date");
        t1.add("cherry");
        t1.add("fig");
        t1.add("banana");
        t1.add("grapes");

        System.out.println("Entries in sorted Set : " + t1);
        System.out.println("Entries greater than cherry : " + t1.tailSet("cherry"));
        System.out.println("Entries less than cherry : " + t1.headSet("cherry"));

        // problem 4
        //{10, 20, 30, 40, 50}

        TreeSet<Integer> t2 = new TreeSet<>();
        t2.add(10);
        t2.add(20);
        t2.add(30);
        t2.add(40);
        t2.add(50);

        System.out.println("Current Entries in problem 4 Set : " + t2);

        System.out.println("SubSet within the range : " + t2.subSet(20, 40));


        /*5.
            Find Next Largest Element
            Problem: Given a set of integers, find the smallest element that is larger than a given number.
            Methods to Use: tailSet(E fromElement)
            Example Input:
            Set: {10, 15, 20, 25, 30}
            Target: 18
            Expected Output: 20
        */

        TreeSet<Integer> t3 = new TreeSet<>();
        t3.add(10);
        t3.add(15);
        t3.add(20);
        t3.add(25);
        t3.add(30);

        System.out.println("smallest element larger from the given number : " + t3.tailSet(18).first());


        /*

            6. Remove Elements Outside a Range
            Problem: Given a set of integers, remove all elements outside a specific range (inclusive).
            Methods to Use: subSet(E fromElement, E toElement), clear(), addAll()
            Example Input:
            Set: {1, 2, 3, 4, 5, 6, 7}
            Range: 3 to 6
            Expected Output: {3, 4, 5, 6}

        */



        /*
            7. Find Closest Elements
            Problem: Given a sorted set of numbers and a target number, find the closest smaller and larger elements.
            Methods to Use: headSet(E toElement), tailSet(E fromElement)
            Example Input:
            Set: {1, 3, 5, 7, 9}
            Target: 6
            Expected Output:
            Closest Smaller: 5
            Closest Larger: 7


            8. Maintain Sorted Order While Inserting
            Problem: Insert a list of numbers into a SortedSet and verify that the set maintains sorted order.
            Methods to Use: addAll(Collection<? extends E>)
            Example Input: {5, 1, 3, 9, 7}
            Expected Output: {1, 3, 5, 7, 9}


            9. Merge Two Sorted Sets
            Problem: Given two SortedSet objects, merge them into a single sorted set without duplicates.
            Methods to Use: addAll(Collection<? extends E>)
            Example Input:
            Set 1: {1, 3, 5}
            Set 2: {2, 4, 6}
            Expected Output: {1, 2, 3, 4, 5, 6}


            10. Count Elements in a Range
            Problem: Given a set of integers, count how many elements fall within a specified range (inclusive of both boundaries).
            Methods to Use: subSet(E fromElement, E toElement)
            Example Input:
            Set: {1, 2, 3, 4, 5, 6}
            Range: 2 to 5
            Expected Output: 4


            11. Find Median Element
            Problem: Find the median of a SortedSet. If the set has an even number of elements, return the average of the two middle elements.
            Methods to Use: Iteration with iterator()
            Example Input: {10, 20, 30, 40, 50}
            Expected Output: 30


            12. Reverse a SortedSet
            Problem: Reverse the order of elements in a SortedSet.
            Methods to Use: descendingSet()
            Example Input: {1, 2, 3, 4, 5}
            Expected Output: {5, 4, 3, 2, 1}
*/


    }


}
