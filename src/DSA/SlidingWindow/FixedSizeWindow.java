package SlidingWindow;

import java.util.*;

public class FixedSizeWindow {
    public static int[] firstNegativeIntegerBrute(int[] input, int k) {
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

    public static int[] firstNegativeIntegerSlididng(int[] input, int k) {
        int r = 0, l = 0, size = input.length;
        int[] result = new int[size - k + 1];
        Queue<Integer> q = new ArrayDeque<>();
        while (r < k - 1) {
            if (input[r] < 0) {
                q.add(input[r]);
            }
            r++;
        }
        while (r < size) {
            if (input[r] < 0) {
                q.add(input[r]);
            }
            if (q.isEmpty()) {
                result[l] = 0;
            } else {
                if (input[l] == q.peek()) {
                    result[l] = q.remove();
                } else {
                    result[l] = q.peek();
                }
            }
            r++;
            l++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] inputArray = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println("Output : " + Arrays.toString(firstNegativeIntegerBrute(inputArray, k)));
        System.out.println("Sliding output" + Arrays.toString(firstNegativeIntegerSlididng(inputArray, k)));
    }
}
