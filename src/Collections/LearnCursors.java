package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class LearnCursors {
    /*
        Cursors are used to retrieve data from collection object one by one,
        Three cursors : Enumerator, Iterator, ListIterator

        Enumerator : used for Stack and Vector as they are 1.0 : offers hasNextElements(), next() - unidirectional
        Iterator : offers three methods - hasNext(), next(), remove() - unidirectional
        ListIterator : bidirectional, child interface of Iterator

        All List implemented classes provide a method called listIterator()
        public ListIterator listIterator()

        ListIterator methods :
                public boolean hasNext();
                public Object next();
                public boolean hasPrevious();
                public Object previous();
                public int nextIndex();
                public int previousIndex();
                public void remove();
                public void add(E e);
                public void set(E e);


    */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

        Iterator<Integer> itr = list.iterator();
        System.out.println("Iterator "+ itr.next());
    }
}
