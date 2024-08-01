//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        
        // length of row and column
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Initialize boundary variables
        int top = 0, bottom = m-1, 
            left = 0, right = n-1;
            
        ArrayList<Integer> list = new ArrayList<>();
        
        // Iterate untill all elements are added
        while (top <= bottom && left <= right) {
            
            // add elements of top row from left to right
            for (int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            
            // add elements of rigth column from top to bottom
            for (int i=top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            
            // add elements of bottom row from rigth to left
            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // add elements of left column from bottom to top
            if (left <= right) {
                for (int i=bottom; i>=top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return list;
    }
}
