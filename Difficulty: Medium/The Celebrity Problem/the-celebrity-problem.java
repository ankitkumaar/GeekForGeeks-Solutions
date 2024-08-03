//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // Initialize variables to 
        // store number of rows and column
        int n = mat.length;
        
        // declare an array to store frequency
        int[] indeg = new int[n];
        int[] outdeg = new int[n];
        
        // query for all edges
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                
                int x = 0;
                if (mat[i][j] == 1) {
                    x = 1;
                }
                else {
                    x = 0;
                }

                // set the degrees
                outdeg[i] += x;
                indeg[j] += x;
            }
        }

        // find a person with indegree n-1 and out degree 0
        for (int i = 0; i < n; i++) {
            if (indeg[i] == n - 1 && outdeg[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}