package collections;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class LearnArrayList {
    // Duplicates allowed.
    // Insertion order preserved.

    /*
     *  Methods of Collection Interface :
     *       boolean add(Object o);              -       Add an object to the collection
     *       boolean addAll(Colleciton c);       -       Add all the objects of specified collection
     *       boolean remove(Object o);           -       Removes the single instance of the specified element from this collection
     *       boolean removeAll(Colleciton c);    -       Removes all of this collection's elements that are also contained in the specified collection
     *       boolean retainAll(Collection c);    -       Retains only the elements in this collection that are contained in the specified collection.
     *       int size()                          -       Returns the number of elements in this collection
     *       boolean contains(Object o)          -       Returns true if this collection contains the specified object
     *       void clear()                        -       Removes all the objects from this collection
     *       boolean isEmpty()                   -       Returns true if this collection contains no elements
     *       Iterator<E> iterator()              -       Returns an iterator over the elements in this collection
     *
     * */

    /*
     *  Methods of List Interface :
     *       void add(int index, E element)      -      Inserts the specified element at the specified position in this list (elements may shift)
     *       E set(int index, E element)         -      Replaces the element at the specified position in this list with the specified element
     *       E get(int index)                    -      Returns the element at the specified position in this list.
     *       int indexOf(Object o)               -      Returns the first occurence of the specified element in this list, or -1 if list does not contain the element.
     *       int lastIndexOf(Object o)           -      Returns the index of last occurence of the specified element in this list, or -1 if list doesn't contain the element.
     *       E remove(int index)                 -      Removes the element at the specified position in the list
     *       List<E> subList(int fromIndex, int toIndex) - Returns a view of the portion of this list between fromIndex inclusive and toIndex exclusive.
     * */

    /*
     *   ArrayList :
     *       ArrayList is defined using dynamic arrays hence it is resizable.
     *       Duplicates are allowed
     *       Order of elements are preserved
     *       Null insertion is possible
     *       Heterogeneous objects are allowed except TreeSet and TreeMap
     *
     * */

    // Create an ArrayList
    // Creates an empty arrayList object with default initial capacity "10" if ArrayList reaches it's max capacity then new ArrayList will be created with following formula :
    //          New capacity = (current capacity * 3/2)+1;
    //ArrayList<Integer> l1 = new ArrayList();

    //     ArrayList a = new ArrayList(collection c);
    //     creates an equivalent ArrayList object for the given Collection.


    public static void main(String[] args) {

         /*  Create an empty ArrayList of integers.
            Add five elements (e.g., 1, 2, 3, 4, 5) to the list using add().
            Insert an element (e.g., 10) at index 2 using add(index, element).

            Remove the element 3 using remove(Object o).
            Remove the element at index 1 using remove(index).
        */
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        arr.add(2, 10);

        System.out.println("Current arrayList :" + arr);

        arr.remove(Integer.valueOf(3));

        arr.remove(1);

        System.out.println("Current arrayList :" + arr);

        /*
                Create two ArrayList<String> objects, list1 and list2.
                Add elements ("A", "B", "C") to list1 and ("D", "E", "F") to list2.
                Combine the two lists using addAll().
                Check if list1 contains all elements of list2 using containsAll().
                Remove all elements of list2 from list1 using removeAll().
        */

        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();

        str1.add("A");
        str1.add("B");
        str1.add("C");

        str2.add("D");
        str2.add("E");
        str2.add("F");

        str1.addAll(str2);

        System.out.println("Two list combined are as follows : " + str1);
        System.out.println("Does str1 contain all the element of str2 : " + str1.containsAll(str2));
        System.out.println("Removing all elements of str2 from str1 : " + str1.removeAll(str2) + " , Remaining elements in str1 : " + str1);

        /*
                    Create a list of strings: ["Alpha", "Beta", "Gamma", "Delta"].
                    Retrieve the element at index 2 using get(index).
                    Update the element at index 1 to "BetaUpdated" using set(index, element).
                    Find the index of "Gamma" using indexOf(element).
                    Add "Alpha" again and find its last occurrence using lastIndexOf(element).

        */

        ArrayList<String> str3 = new ArrayList<>(4);
        str3.add("Alpha");
        str3.add("Beta");
        str3.add("Gamma");
        str3.add("Delta");

        System.out.println("Element at index 2 : " + str3.get(2));
        System.out.println("Updating element at index 1 : " + str3.set(1, "BetaUpdated") + " , Updated list : " + str3);
        System.out.println("Index of Gamma in list : " + str3.indexOf("Gamma"));
        System.out.println("Adding alpha again and finding it's index : " + str3.add(String.valueOf("Gamma")) + " ,Index of Gamma : " + str3.lastIndexOf(String.valueOf("Gamma")));

        /*
        *           4. Iterating Over Lists
                    Goal: Practice different iteration methods.

                    Create a list of Double values: [1.1, 2.2, 3.3, 4.4].
                    Use a for-each loop to print all elements.
                    Use an Iterator to print all elements.
                    Use a ListIterator to traverse the list both forward and backward.

                    5. Sublist and Sorting
                    Goal: Extract and rearrange parts of the list.

                    Create a list of integers: [10, 20, 30, 40, 50, 60].
                    Extract a sublist from index 2 to 5 using subList(fromIndex, toIndex).
                    Sort the list in ascending order using sort().
                    Sort the list in descending order using a custom comparator.

                    6. Checking and Clearing
                    Goal: Work with list properties.

                    Create a list and check if it is empty using isEmpty().
                    Add some elements and check the size of the list using size().
                    Check if the list contains a specific element using contains(element).
                    Clear the list using clear() and verify it's empty.

                    7. Advanced: Streams and Parallel Streams
                    Goal: Explore modern Java features.

                    Create a list of integers: [1, 2, 3, 4, 5, 6, 7, 8, 9].
                    Use stream() to filter all even numbers and collect them into a new list.
                    Use stream() to find the sum of all elements.
                    Use parallelStream() to multiply each element by 2 and print the results.

        * */

        ArrayList<Double> list1 = new ArrayList<>(4);
        list1.add(1.1);
        list1.add(2.2);
        list1.add(3.3);
        list1.add(4.4);

        for (Double element : list1) {
            System.out.println("The element in list1 " + element);
        }

        // Obtain an iterator
        Iterator<Double> iterator = list1.iterator();

        // Iterate through the list
        System.out.println("Printing the list below using iterator : ");
        while (iterator.hasNext()) {
            Double valueInIterator = iterator.next();
            System.out.println("Current value in iterator from list : " + valueInIterator);
        }

        // Obtain listIterator
        ListIterator<Double> itr1 = list1.listIterator();

        // Iterate through list

        System.out.println("Printing list in using listIterator : ");
        while (itr1.hasNext()) {
            System.out.println("Element : " + itr1.next());
        }

        System.out.println("Printing list in reverse using listIterator : ");
        while (itr1.hasPrevious()) {
            System.out.println("Element : " + itr1.previous());
        }

        // Sublist and sorting : [10, 20, 30, 40, 50, 60]

        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(30);
        list2.add(40);
        list2.add(10);
        list2.add(20);
        list2.add(50);
        list2.add(60);

        System.out.println("Sub list from the list : " + list2.subList(2, 5));

        // sort the list in ascending order :
        list2.sort((i, j) -> i.compareTo(j));
        System.out.println("Sorted list : " + list2);

        // sort the list in descending order :
        list2.sort((i, j) -> j.compareTo(i));
        System.out.println("Sorted list in decreasing order : " + list2);

        // sorting in ascending order using collections.sort
        Collections.sort(list2);
        System.out.println("Sorted list using Collections.sort: " + list2);

        // Create a list and check if it is empty using isEmpty().
        //                    Add some elements and check the size of the list using size().
        //                    Check if the list contains a specific element using contains(element).
        //                    Clear the list using clear() and verify it's empty.

        System.out.println("Checking if list2 is empty : " + list2.isEmpty());
        System.out.println("Checking the size of list2 : " + list2.size());
        System.out.println("Checking if 12 exists in list2 : " + list2.contains(12));
        System.out.println("Checking if list2 containsAll elements of list1 : " + list2.containsAll(arr));
        list2.clear();
        System.out.println("Deleted the list2 elements : " + list2);


        //                    Create a list of integers: [1, 2, 3, 4, 5, 6, 7, 8, 9].
        //                    Use stream() to filter all even numbers and collect them into a new list.
        //                    Use stream() to find the sum of all elements.
        //                    Use parallelStream() to multiply each element by 2 and print the results.

        // Declare a List of Integer type
        List<Integer> nums = new ArrayList<>();

        // Add values to the list
        nums.add(100);
        nums.add(201);
        nums.add(3003);
        nums.add(-405);
        nums.add(50);

        // Print the list
        System.out.println("List of Integers: " + nums);


        // using stream
        List<Integer> sortedNums1 = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println("Filtered the list using stream to get even numbers : "+ sortedNums1);



    }

}
