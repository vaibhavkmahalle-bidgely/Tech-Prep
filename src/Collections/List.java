package Collections;

import java.util.ArrayList;

public class  List {
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
            ArrayList<Integer> l1 = new ArrayList();

     //     ArrayList a = new ArrayList(collection c);
     //     creates an equivalent ArrayList object for the given Collection.


    ArrayList<Integer> arr = new ArrayList<>();
}
