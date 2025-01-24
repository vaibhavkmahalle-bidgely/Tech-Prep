package Collections;

import java.util.*;

public class LearnLinkedList {

    public static LinkedList<Integer> enqueue(LinkedList<Integer> list3, int a) {
        list3.addLast(a);
        return list3;
    }

    public static LinkedList<Integer> dequeue(LinkedList<Integer> list3) {
        if (list3.isEmpty()) {
            throw new RuntimeException("queue is empty, cannot perform dequeue operation");
        }

        list3.removeFirst();

        return list3;

    }


    /*
        In linked list the data is stored in different physical locations.
        The underlying data structure is Doubly Linked List.


        Methods of LinkedList :

        void addFirst(Object o)
        void addLast(Object o)
        Object getFirst(),
        Object getLast(),
        Object removeFirst(),
        Object removeLast()
    */
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();

        llist.addFirst(2);
        llist.addFirst(3);
        llist.add(1, 9); // add method from List interface
        llist.add(10);// add method from collections interface

        System.out.println("linked list " + llist);
        System.out.println("First element of list : " + llist.getFirst());
        System.out.println("Last element of List : " + llist.getLast());
        System.out.println("Removed first element of list : " + llist.removeFirst());
        System.out.println("Removed last element of List : " + llist.removeLast());
        System.out.println("linked list after removal : " + llist);


        /*
            Constructors in LinkedList :
            LinkedList()
            LinkedList(Collection c)
        * */

        /*
            Practicing methods with problems on LinkedList.

            1. Basic Operations
                add(E e): Adds an element to the end of the list.
                add(int index, E element): Inserts an element at a specified position.
                remove(int index): Removes the element at the specified position.
                remove(Object o): Removes the first occurrence of the specified element.
                get(int index): Retrieves the element at the specified position.
                set(int index, E element): Replaces the element at the specified position.
                size(): Returns the number of elements in the list.
              Problems to Practice:
                Add five elements to a LinkedList and remove the third element. Print the list before and after removal.
                Insert an element at the second position and update the last element. Print the updated list.
                Write a program to find the middle element of a LinkedList.
*/

        LinkedList llist2 = new LinkedList();
        llist2.add("Adding");
        llist2.add(1, "five");
        llist2.add("elements");
        llist2.add("to");
        llist2.add("linkedList");

        System.out.println(llist2);
        System.out.println("Size of linkeList : " + llist2.size());
        System.out.println("Getting third element of the linkedList : " + llist2.get(3));
        System.out.println("Setting fourth element of the linkedlist as helloKitty : " + llist2.set(3, "helloKitty"));
        System.out.println("checking list : " + llist2);
        System.out.println("Removing last element : " + llist2.removeLast());
        System.out.println("Removing first occurence of helloKitty : " + llist2.remove("helloKitty"));

        System.out.println("final list : " + llist2);



/*

           2. Queue/Deque Operations
                addFirst(E e): Inserts the element at the beginning.
                addLast(E e): Appends the element to the end.
                removeFirst(): Removes the first element.
                removeLast(): Removes the last element.
                getFirst(): Retrieves the first element.
                getLast(): Retrieves the last element.
             Problems to Practice:
                Use a LinkedList to implement a queue. Perform enqueue (addLast) and dequeue (removeFirst) operations.
                Use a LinkedList to implement a stack. Perform push (addFirst) and pop (removeFirst) operations.
                Given a list of numbers, rotate the list to the right by k steps using addFirst and removeLast.
*/

        LinkedList<Integer> queue = new LinkedList<>();

        LearnLinkedList.enqueue(queue, 2);
        LearnLinkedList.enqueue(queue, 1);
        LearnLinkedList.enqueue(queue, 4);

        System.out.println("queue after enqueue operations on queue : " + queue);

        LearnLinkedList.dequeue(queue);
        System.out.println("queue after dequeue operation : " + LearnLinkedList.dequeue(queue));






        /*
           3. Search and Traversal
                contains(Object o): Checks if the list contains the specified element.
                indexOf(Object o): Returns the index of the first occurrence of the specified element.
                lastIndexOf(Object o): Returns the index of the last occurrence of the specified element.
              Problems to Practice:
                Write a program to check if a given element exists in a LinkedList. If it does, return its index; otherwise, return -1.
                Find the index of the first and last occurrence of a specific element in a LinkedList.

        */
        System.out.println("Checking if queue contains 4 : " + queue.contains(4));
        System.out.println("Index of 1 : " + queue.indexOf(1));
        LearnLinkedList.enqueue(queue, 1);
        LearnLinkedList.enqueue(queue, 1);
        LearnLinkedList.enqueue(queue, 1);
        LearnLinkedList.enqueue(queue, 2);

        System.out.println("Last Index of 1 : " + queue.lastIndexOf(1));
        System.out.println("Size of queue : " + queue.size());





        /*

           4. Iteration
                iterator(): Returns an iterator for the list.
                listIterator(): Returns a list iterator to traverse the list in both directions.
                forEach(): Performs the given action for each element.
              Problems to Practice:
                Iterate over a LinkedList using an iterator and print all the elements.
                Traverse a LinkedList in reverse order using a ListIterator.
        */
        Iterator<Integer> itr = queue.iterator();

        System.out.println("Printing the iterator : " + itr);
        System.out.println("Printing if iterator hasNext : " + itr.hasNext());
        while (itr.hasNext()) {
            System.out.println("Printing the queue using iterator :" + itr.next());
        }

        ListIterator<Integer> listIterator = queue.listIterator();

        System.out.println("checking both previous and next of the iterator : " + listIterator.hasNext() + " " + listIterator.hasPrevious());
        for(int element : queue){
            System.out.println("Iterator and element printing side by side : "+ element + " " + listIterator.next());
            System.out.println("Printing previous as well : "+ listIterator.previous());
        }
        /*
            5. Conversion
                toArray(): Converts the list to an array.
                clear(): Removes all elements from the list.
                clone(): Creates a shallow copy of the list.
              Problems to Practice:
                Convert a LinkedList to an array and print the array.
                Clone a LinkedList, modify the clone, and show that the original list remains unchanged.

        */
        System.out.println("Converting linkedlist to an array : ");
        System.out.println("Converted the linkedList to an array : " + Arrays.toString(llist.toArray()));
        // llist.toArray() returns an array of Object[] type if we print that directly it will print the memory reference of the array and not the content
        // so we need to convert that to a readable string to print it.

        System.out.println("Checking what is present in llist after converting to array : " + llist);
        System.out.println("Creating shallow copy of the list : ");
        Object clonedList = llist.clone();
        llist.add(55);

        llist.set(1,88);
        System.out.println("Printing cloned list and original list : " + clonedList + " original List : "+ llist);
        System.out.println("Clearing the list : ");
        llist.clear();
        System.out.println("Printing cloned list and original list after clearing : " + clonedList + " original List : "+ llist);



        /*

           6. Other Useful Methods
                isEmpty(): Checks if the list is empty.
                subList(int fromIndex, int toIndex): Returns a view of the portion of the list between fromIndex and toIndex.
                peek(): Retrieves the first element without removing it.
                poll(): Retrieves and removes the first element.
              Problems to Practice:
                Split a LinkedList into two sublists using subList().
                Implement a program to check if a LinkedList is empty before performing any operations.
                Use peek() and poll() to simulate a queue and demonstrate their difference.

                Comprehensive Practice Problem
                Design a To-Do List Manager:

Use a LinkedList to store tasks.
Add tasks at the beginning or end of the list.
Remove tasks by name or index.
Display tasks in order or reverse order.
Search for a task by name and display its position.
        */
    }


}
