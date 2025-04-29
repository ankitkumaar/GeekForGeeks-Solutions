//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        
        int result = 0, x, sum;

        /* Iterate through every bit (from 0 to 31) */
        for (int i = 0; i < 32; i++) {
            sum = 0;
            
            /* Mask for the i-th bit */
            x = (1 << i);

            /* Count how many numbers have the i-th bit set */
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & x) != 0) {
                    sum++;
                }
            }

            /* If sum is not a multiple of 3, that bit belongs
            to the unique number */
            if ((sum % 3) != 0) {
                result |= x;
            }
        }
        return result;
    }
}