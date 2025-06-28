package DSA.DP;

public class LCS {
        static String[][] dp;
        static String lcs(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            dp = new String[m+1][n+1];

            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i==0 || j==0){
                        dp[i][j] = "";
                    }
                }
            }

            return getlcs(s1,s2,m,n);
        }

        static String getlcs(String s1, String s2, int m, int n){
            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = s1.charAt(i-1)+dp[i-1][j-1];
                    }else{
                          dp[i][j] = "";
                    }

                }

            }
            return dp[m][n];
        }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";
        String result = new StringBuilder(lcs(s1, s2)).reverse().toString();


        System.out.println("Length of LCS: " + result);

    }

}
