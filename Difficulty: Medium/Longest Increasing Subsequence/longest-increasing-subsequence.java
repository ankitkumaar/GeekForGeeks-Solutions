//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    static int lis(int arr[]) {
        
        /* Array to store the smallest ending element of increasing subsequence of each length */
        int[] tails = new int[arr.length];
        int size = 0;
        
        for (int x : arr) {
            int i = 0, j = size;
            
                /* Binary search to find the insertion point of x in tails array */
                while (i != j) {
                    int m = (i + j) / 2;
                    if (tails[m] < x)
                        i = m + 1;
                    else
                        j = m;
                }
            /* Place x at its correct position in the tails array */
            tails[i] = x;
            /* If x was placed at the end, increase the size of LIS */
            if (i == size) ++size;
        }
        return size;
    }
}