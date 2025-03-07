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
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) {
        
    int n = s.length();
    
    /* Create two arrays: one for the current state
    and one for the previous state */
    int[] curr = new int[n];
    int[] prev = new int[n];

    /* Loop through the string in reverse */
    for (int i=n-1; i>=0; i--) {
        
      curr[i] = 1;
      for (int j=i+1; j<n; j++) {

        /* If the characters at i and j are the same */
        if (s.charAt(i) == s.charAt(j)) {
          /* Add 2 to the length of the palindrome between them */
          curr[j] = prev[j-1] + 2;
        } 
        else {
          /* Take the maximum between excluding either i or j */
          curr[j] = Math.max(prev[j], curr[j-1]);
        }
      }

      /* Update previous to the current state of dp */
      prev = curr.clone();
    }
    return curr[n-1];
    }
}