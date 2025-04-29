//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    public int[] singleNum(int[] arr) {
        
        /* Get the XOR of the two numbers we need to find */
        int xorVal = 0;
        for (int num : arr) {
            xorVal ^= num;
        }

        /* Get its last set bit */
        xorVal &= -xorVal;

        int[] res = new int[2];
        for (int num : arr) {
            
            /* If bit is not set, it belongs to the first set */
            if ((num & xorVal) == 0) 
                res[0] ^= num;
            
            /* If bit is set, it belongs to the second set */
            else
                res[1] ^= num;
        }

        /* Ensure the order of the returned numbers is consistent */
        if (res[0] > res[1]) {
            
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int[] ans = ob.singleNum(arr);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends