package SlidingWindow;

import java.util.*;

public class FixedSizeWindow {
    public static int[] firstNegativeInteger(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;

        //{-8, 2, 3, -6, 10}, k =2

        for (int i = 0; i <= input.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (input[j] < 0) {
                    list.add(input[j]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(0);
            }
            flag = true;
        }

        int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 2;

        System.out.println("Output : "+ Arrays.toString(firstNegativeInteger(inputArray,k)));
    }
}
