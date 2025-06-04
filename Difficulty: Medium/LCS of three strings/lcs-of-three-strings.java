class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        /* Create a 3D array (dp) to store the LCS lengths
        for each combination of substrings */
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        /* dp[i][j][k] contains length of LCS of s1[0..i-1],
        s2[0..j-1], and s3[0..k-1] */
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    
                    /* Base Case: any string is empty */
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0; 
                    }
                    
                    else if (s1.charAt(i - 1) == s2.charAt(j - 1)
                        && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                                 
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1]+ 1;  
                    }
                    
                    else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k],
                                      dp[i][j - 1][k]),dp[i][j][k - 1]);  
                    }
                }
            }
        }

        /* dp[n1][n2][n3] contains length of LCS for
        s1[0..n1-1], s2[0..n2-1], and s3[0..n3-1] */
        return dp[n1][n2][n3];
    }
}