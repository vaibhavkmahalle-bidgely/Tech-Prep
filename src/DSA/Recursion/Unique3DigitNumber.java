package dsa.recursion;
import java.util.*;


public class Unique3DigitNumber {
    public static int getTotal(List<Integer> input, int count, int current ){
        // base condition
        if(input.isEmpty()){
            if(current > 99 && current <=999 ){
                System.out.println("current :- "+ current+ ", count : " + count);
                count++;
            }
            return count;
        }

        int x = input.remove(0);
        count = getTotal(input, count, current);
        current = current*10+x;
        count = getTotal(input, count, current);
        System.out.println("adding x " + x);
        input.add(x);
        return count;
    }
    public static int totalNumbers(int[] digits) {
        List<Integer> input = new ArrayList<>();
        int count = 0;
        int current = 1;

        for(int i : digits){
            input.add(i);
        }

        int i = 0;
        int sum = 0;
        while( i < digits.length){
            System.out.println("input : "+input + ", current : "+ current+ ", count : "+ count);
            sum += getTotal(input, current, count);
            System.out.println("sum : " + sum);
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        int result = totalNumbers(digits);
    }
}

