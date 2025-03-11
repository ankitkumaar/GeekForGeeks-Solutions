//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        
        /* Base cases: If there are 0 or 1 stairs, there is only 1 way to climb */
        if(n == 0 || n == 1)
            return 1;
        
        /* If there are 2 stairs, there are 2 ways to climb (1+1 or directly 2) */
        if(n == 2)
            return 2;
        
        /* Initializing the dp array to store results of subproblems */
        int dp[] = new int[n+1];
        /* Setting base values */
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        /* Filling the dp array using the recurrence relation */
        for(int i=3; i<=n; i++)  {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
