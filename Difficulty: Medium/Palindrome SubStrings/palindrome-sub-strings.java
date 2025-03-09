//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String s) {
        
        int res = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        /* One length string is always palindrome */
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        /* Two length string is palindrome if
        both characters are same */
        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }

        /* Handle palindromes of length greater than 2 */
        for (int gap=2; gap<n; gap++) { 
            for (int i=0; i<n-gap; i++) {
                int j = i + gap;

                /* Check if the current string is a palindrome */
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}