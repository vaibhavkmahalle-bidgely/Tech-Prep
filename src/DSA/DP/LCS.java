package DSA.DP;
import java.util.Arrays;
// print lcs
public class LCS {
        static int[][] dp;
        static String lcs(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            dp = new int[m+1][n+1];

            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }
                }
            }

            return getlcs(s1,s2,m,n);
        }

        static String getlcs(String s1, String s2, int m, int n){
            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1+ dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }

                }

            }
            return lcsString(s1,s2,m,n);
        }

        static String lcsString(String s1, String s2, int m, int n){
            int i = m, j = n;
            String result = "";
            while(i>0 && j>0){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    result = result + s1.charAt(i-1);
                    i--;
                    j--;
                }else{
                    if(dp[i-1][j] >= dp[i][j-1]){
                        i--;
                    }else{
                        j--;
                    }
                }
            }
            return result;
        }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "aedfhr";
        String result =lcs(s1, s2);
        System.out.println(Arrays.deepToString(dp));


        System.out.println("Length of LCS: " + result);



    }

}
