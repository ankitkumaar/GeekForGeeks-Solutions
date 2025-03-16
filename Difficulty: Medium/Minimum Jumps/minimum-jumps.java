//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        
        int n = arr.length;

        /* Return -1 if not possible to jump */
        if (arr[0] == 0)
            return -1;

        /* Variables to Store the maximal reachable index,
        the number of steps we can still take and 
        stores the number of jumps needed to reach current reachable index */
        int maxReach = 0, currReach = 0, jump = 0;
        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);

            /*If we can reach last index by jumping 
            from current position return Jump + 1 */
            if (maxReach >= n - 1)
                return jump + 1;

            /* Increment the Jump as we reached the Current Reachable index */
            if (i == currReach) {

                /* If Max reach is same as current index then we can not jump further */
                if (i == maxReach)
                    return -1;

                /* If Max reach > current index then increment jump and 
                update current reachable index */
                else {
                    jump++;
                    currReach = maxReach;
                }
            }
        }
        return -1;
    }
}