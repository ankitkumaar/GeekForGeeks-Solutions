//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxValue(int[] arr) {
        
        int n = arr.length;
        
        /* Edge case: If there's only one house, return its value */
        if (n == 1) return arr[0];
        
        /* Solve for both cases and return the maximum of the two */
        return Math.max(rob(arr, 0, n - 2), rob(arr, 1, n - 1));
    }

    private int rob(int[] nums, int l, int r) {
        int prev2 = 0, prev1 = 0;
        for (int i = l; i <= r; i++) {
            
            /* Calculate the maximum value by either robbing the current house or skipping it */
            int curr = Math.max(prev1, prev2 + nums[i]);
            
            /* Update previous values for the next iteration */
            prev2 = prev1;
            prev1 = curr;
        }
        
        /* The last computed value is the maximum amount that can be robbed */
        return prev1;
    }
}