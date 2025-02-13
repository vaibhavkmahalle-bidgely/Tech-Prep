package DSA.SearchingAndSorting;


public class SqrtNumber {
    public static long findSqrt(long n) {
        long ans = 1;
        if (n == 1 || n == 2) return 1;
        for (long i = 3; i < n; i++) {
            System.out.println("i : " + i);
            if (i * i == n) {
                ans = i;
                System.out.println("ans : " + ans);
                return i;
            }

            if (i * i > n) {
                ans = i - 1;
                System.out.println("ans2 : " + ans);
                return ans;
            }
        }
        System.out.println("final ans : " + ans);
        return ans;

    }

    public static int NthRoot(int N, int M) {
        int low = 1, high = M, ans = -1;
        if (N == 1) {
            return M;
        }
        while (low <= high) {

            int mid = low + (high - low) / 2;
            System.out.println("low, mid, high : " + low + ", " + mid + ", " + high);
            int midComp = 1;
            midComp = (int) Math.pow(mid, N);
            System.out.println("midComp and N : " + midComp + "," + N);
            if (midComp == M) {
                ans = mid;
            }
            if (midComp < M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int smallestDivisor(int[] nums, int limit) {
        int k = 1, sum = 0, ans = 0;
        while (true) {
            sum =0;
            System.out.println("k :"+ k);
            for (int i = 0; i < nums.length; i++) {
                sum +=  (nums[i] + k -1)/k;
            }
            System.out.println("sum : "+ sum);
            if (sum <= limit) {
                ans = k;
                System.out.println(" ans : "+ ans);
                return ans;
            }
            k++;
        }
    }

    public static void main(String[] args) {
       // System.out.println("7th root of 128 : " + NthRoot(7, 128));
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("smallest Divisor : " + smallestDivisor(nums,8));
    }


}
