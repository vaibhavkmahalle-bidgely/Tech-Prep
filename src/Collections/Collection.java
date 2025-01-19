package Collections;

public class Collection {

    // All methods in interface are by default public :
    // so the class which implements the Interface must declare all the methods as public;

    // Interfaces in collection :

        // :: collection : for group of objects. It is a parent interface for all the interfaces in collection framework.
                // 1. List :
                //       Duplicates allowed,
                //       Insertion order must be preserved
                //       (ArrayList,LinkedList,Vector->Stack) :-> are the implementation classes.

                // 2. Set :
                //       collection that cannot contain duplicate elements
                //       Insertion order is not preserved
                //       HashSet->LinkedHashSet are the implementation Classes for Set interface.

                //              2.a SortedSet :
                //                  Child interface of Set
                //                  Cannot contain duplicate elements
                //                  Some sorted order

                //                  2.a.1 NavigableSet :
                //                       Child interface of SortedSet
                //                       It defines several methods for navigation purposes
                //                       TreeSet is implementation class

                // 3. Queue :
                //          Child interface of collection
                //          PriorityQueue, BlockingQueue -> (LinkedBlockingQueue, PriorityBlockingQueue) are implementation classes

            /*
            *   Map :
            *       It is used to represent group of objects as key value pairs.
            *       Map is not a child interface of collection
            *       Key and values both are objects
            *       Keys must be unique but values can repeat
            *       HashMap -> LinkedHashMap, WeakHashMap, IdentityHashMap, Hashtable->properties :  these are implementation classes.
            *
            *       SortedMap :
            *           Child interface of map.
            *           Some sorting order.
            *
            *            NavigableMap :
            *               Child interface of SortedMap.
            *               TreeMap is implementation class.
            *
            *
            *  Comparable :
            *       Interface for default sorting
            *
            *  Comparatpr :
            *       Interface for customized sorting
            *
            * */

}
