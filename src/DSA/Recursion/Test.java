package DSA.Recursion;// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Test {

    public static int digital_root(int i){
        int sum = 0;
        while(i > 0){
            sum += i%10;
            i = i/10;
        }
        return sum;
    }

    public static void transform(int[] input){
        int sum = 0;
        for(int i =0; i< input.length; i++) {
            sum += digital_root(input[i]);
        }
    }

    public static void main(String[] args) {
        int[] input = {12, 25, 7};
        transform(input);


    }


//    You are given an array of positive integers. You need to transform this array such that:
//    Each element becomes its digital root (repeatedly sum digits until single digit)
//    The resulting array has the maximum possible sum
//    You can perform operations before calculating digital roots
//    Operations allowed (each costs 1):
//    Add 1 to any element
//    Subtract 1 from any element (element must remain positive)
//    The digital root of a number is calculated by repeatedly summing its digits until a single digit remains.
//    Examples:
//    digital_root(38) = 3+8 = 11 → 1+1 = 2
//    digital_root(9) = 9
//    digital_root(10) = 1+0 = 1
//    Goal: Find the minimum cost to maximize the sum of digital roots.
//            Example:
//    Input: [12, 25, 7]
//    Current digital roots: [3, 7, 7] → sum = 17
//    We can:
//            - Change 12 to 9 (cost 3): digital_root(9) = 9
//            - Keep 25 as is: digital_root(25) = 7
//            - Keep 7 as is: digital_root(7) = 7
//
//    Final array: [9, 25, 7] with digital roots [9, 7, 7] → sum = 23
//    Total cost: 3


}