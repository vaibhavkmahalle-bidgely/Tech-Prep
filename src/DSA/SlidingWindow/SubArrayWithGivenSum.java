package dsa.slidingwindow;
import java.util.*;

public class SubArrayWithGivenSum {
    public static ArrayList<Integer> subarraySum(int[] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        // Brute force
        for(int i = 0; i < arr.length; i++){
            int currentSum = 0;
            int j = i;
            while(currentSum <= sum){
                if(currentSum == sum){
                    j++;
                    result.add(arr[i]);
                    result.add(arr[j]);
                    return result;
                }
                currentSum += arr[j];
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        System.out.println("Output : "+ subarraySum(input, sum));
    }
}
