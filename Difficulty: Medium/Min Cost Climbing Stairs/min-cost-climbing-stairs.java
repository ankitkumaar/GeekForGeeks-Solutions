//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        
        /* If there is only one step, return its cost */
        if (cost.length == 1) return cost[0];
        
        /* If there are two steps, return the minimum cost to start */
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        
        /* Dynamic programming approach to calculate minimum cost */
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        /* The result is the minimum cost to reach the last or second-last step */
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
};