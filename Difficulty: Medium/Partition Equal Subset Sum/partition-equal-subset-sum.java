//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        
        /* Calculate sum of the elements in array */
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int n = arr.length;

        /* If sum is odd, there cannot be two subsets with equal sum */
        if (sum % 2 != 0) 
            return false;

        sum = sum / 2;

        /* Create a 2D array for storing results of subproblems */
        boolean[][] dp = new boolean[n + 1][sum + 1];

        /* If sum is 0, then answer is true (empty subset) */
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        /* Fill the dp table in bottom-up manner */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                
                /* Exclude the current element */
                if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                
                /* Include or exclude */
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
        return dp[n][sum];
    }
}