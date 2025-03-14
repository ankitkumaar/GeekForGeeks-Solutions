//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        
        int n = coins.length;
        
        /* 2d dp array where n is the number of coin
        denominations and sum is the target sum */
        int[][] dp = new int[n + 1][sum + 1];

        /* Represents the base case where the target sum is 0,
        and there is only one way to make change: by not selecting any coin */
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                /* Add the number of ways to make change without
                using the current coin */
                dp[i][j] += dp[i - 1][j];

                if ((j - coins[i - 1]) >= 0) {

                    /* Add the number of ways to make change
                    using the current coin */
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}