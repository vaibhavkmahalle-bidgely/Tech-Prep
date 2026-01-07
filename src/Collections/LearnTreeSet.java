package collections;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id, o.id);

    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

class Students implements Comparable<Students> {
    int id;
    String name;
    double salary;

    public Students(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Students o) {
        return CharSequence.compare(this.name, o.name);

    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

class SalaryComparator implements Comparator<Employee>{
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o2.salary, o1.salary);
    }
}

class ReverseOrderComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
       return CharSequence.compare(o2.name,o1.name);
    }
}
public class LearnTreeSet {
    // TreeSet and TreeMap are only two collections where we cannot insert heterogeneous objects anywhere else it is allowed.
    // TreeSet can contaion null value only if the collection does not have any other object i.e. when the Set is empty.

    /*
    Constructors of TreeSet class :
        TreeSet()                   -  Constructs a new TreeSet sorted according to the natural ordering of it's elements
        TreeSet(Comparator c)       -  Constructs a new TreeSet sorted according to the order of comparator
        TreeSet(Collection c)       -  Constructs a new TreeSet containing the elements in the specified collection, sorted according to the natural ordering of the elements
        TreeSet(SortedSet c)        -  Constructs a new TreeSet containing the same elements and same ordering provided in the sorted set
    */

    /*
        Comparable : This is the interface which has compareTo method
        For Natural Order Sorting , the class must implement the interface comparable which has compareTo method.

        Comparable interface : comparable interface belongs to java.lang package

        interface Comparable {
            int compareTo(Object obj);
        }

        o1.compareTo(o2);
        Returns negative value if o1<o2;
        Returns positive value if o1>o2;
        Returns 0 if o1 and o2 are equal;


        Values in tree are printed on the basis of in order traversal

        Comparator is used for custom sorting order.
        It is present in java.util package
        It has two methods : compare(Object ob1, Object ob2), equals())

        int compare(Object ob1, Object ob2) :
            Returns negative if ob1 < ob2;
            Returns positive if ob1 > ob2;
            Returns zero if ob1 and ob2 are equal;

        boolean equals() :
            dummy method implementation is optional.

    */



    public static void main(String[] args) {
        /*Create a TreeSet to store unique names of students. Add a few names and print them in ascending order (natural order).*/

        TreeSet<String> studentNames = new TreeSet<>();
        studentNames.add("Vaibhav");
        studentNames.add("Sachin");
        studentNames.add("Jayanta");
        studentNames.add("Ganesh");
        System.out.println("Current Student Names are : " + studentNames);

        // Create an Employee class with id, name, and salary. Implement Comparable<Employee> to sort employees by ID in ascending order.
        // Modify the Employee class from the previous example. Use a Comparator to sort employees by salary in descending order.
        TreeSet<Employee> employees = new TreeSet<>(new SalaryComparator());

        employees.add(new Employee(4,"Sahana",45000));
        employees.add(new Employee(3,"Sachin",49000));
        employees.add(new Employee(5,"Sankarshan",4500000));

        System.out.println("Employees in the TreeSet : "+ employees);

        System.out.println("Employees after the comparator class : " + employees);


        //Store names in a TreeSet but sort them in reverse alphabetical order.
        TreeSet<Employee> emploice = new TreeSet<>(new ReverseOrderComparator());

        emploice.add(new Employee(22, "Akash", 200009));
        emploice.add(new Employee(12, "Vibhor", 2009));
        emploice.add(new Employee(12, "Kushagra", 200909));

        System.out.println("Employees in reverse natural order : " + emploice);

        // Modify the Students class so that employees with the same name are considered duplicates and are not added to the TreeSet.

        TreeSet<Students> students = new TreeSet<>();

        students.add(new Students(1,"Vaibhav", 2340));
        students.add(new Students(2,"Vaibhav", 22304));
        students.add(new Students(3,"Shubham", 2232));

        System.out.println("Students after being added in students class : " + students);





    }


}
