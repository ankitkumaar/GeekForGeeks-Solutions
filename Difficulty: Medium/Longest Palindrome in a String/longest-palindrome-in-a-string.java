//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        
        int n = s.length();
        if (n == 0) 
            return "";
        
        /* Variables to track the starting index and length of the longest palindrome
        Traverse the input string */
        int start = 0, maxLen = 1;
        for (int i = 0; i < n; i++) {
            
            /* This loop runs twice:
            j = 0 checks for odd-length palindromes (single-character center).
            j = 1 checks for even-length palindromes (two-character center) */
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j; 
                
                /* Expand around the center while it's a palindrome and within bounds */
                while ((low >= 0 && high < n) && (s.charAt(low) == s.charAt(high))) {
                    int currLen = high - low + 1;
                    
                    /* Update maxLen and start if a longer palindrome is found */
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}