package dsa.arrays;

public class ArrayDeclaration {
    public static void main(String[] args) {
        int a[]; // this is just a reference variable which can refer to an array
        a = new int[5]; // now the array is created with memory assigned to it

        int b[] = {1, 2, 3, 4, 5, 6}; // way 2 of declaration and initialization both at the same time.

        int c[] = new int[]{4, 3, 2};
        // int b[] = new int[5]{1,2,3,4,5}; // this is not allowed
        // each array has a length variable which gives us the size of the array.

        System.out.println("Array A");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            // array is never blank so the default values are assigned to array elements.
        }

        System.out.println("Array b");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        int d[][]; // this is reference variable that indicates d will only point to a 2d array.
        d = new int[2][3];
        // d will refer to an array of size 2 which contain two reference variables at d[0], d[1].
        // reference variable at d[0] will refer to an array of size 3, same for d[1].

        int e[][] = {{2,3},{22,33}};
        int f[][] = new int[][]{{2,3},{22,33}};
        int g[][] = new int[4][]; // this is allowed but new int[][] or new int[][4] this is not.


    }
}
