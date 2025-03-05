//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        
        /* Sort words by length */
        /* HashMap to store the maximum chain length for each word */
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        
        int res = 1;
        
        /* Iterate through each word in the sorted array */
        for (String w : words) {
            dp.put(w, 1);
            
            /* Try removing one character at a time */
            for (int i = 0; i < w.length(); i++) {
                String pred = w.substring(0, i) + w.substring(i + 1);
                
                if (dp.containsKey(pred)) {
                    dp.put(w, Math.max(dp.get(w), dp.get(pred) + 1));
                }
            }
            res = Math.max(res, dp.get(w));
        }
        
        return res;
    }
}