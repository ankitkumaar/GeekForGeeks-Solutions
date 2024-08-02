//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int editDistance(String str1, String str2) {
        
        // Store length of both strings
        int m = str1.length();
        int n = str2.length();
        
        // Initialize an array to store current row of edit distances
        int[] curr = new int[n + 1];
        
        // Initialize first row with values 0 to n
        for (int j=0; j<=n; j++) {
            curr[j] = j;
        }
        
        int previous = 0;
        for (int i = 1; i <= m; i++) {
            previous = curr[0];
            curr[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = curr[j];

                // Check if the characters at the current
                // positions in str1 and str2 are the same
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = previous;
                }
                else {
                    curr[j] = 1 + Math.min(Math.min(previous, curr[j - 1]), curr[j]);
                }

                previous = temp;
            }
        }
        
        return curr[n];
    }
}