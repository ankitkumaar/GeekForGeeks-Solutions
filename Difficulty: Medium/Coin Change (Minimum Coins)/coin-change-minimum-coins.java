//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        
        /* Array to store the minimum coins needed for each value up to sum */
        int[] dp = new int[sum + 1];
        
        /* Initialize the dp array with a large value (infinity) */
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        /* Base case: 0 coins are needed to make the sum of 0 */
        dp[0] = 0;
        
        /* Iterate through each coin in reverse order */
        for (int i = coins.length - 1; i >= 0; i--) {
            
            /* Iterate through all sums from 1 to the target sum */
            for (int j = 1; j <= sum; j++) {
                
                /* Initialize variables to track taking 
                or not taking the coin */
                int take = Integer.MAX_VALUE, noTake = Integer.MAX_VALUE;
                
                /* If we can take the current coin */
                if (j - coins[i] >= 0 && coins[i] > 0) {
                    take = dp[j - coins[i]];
                    
                    /* If taking the coin is possible, increment the count */
                    if (take != Integer.MAX_VALUE) take++;
                }
                
                /* If there are more coins available,
                consider not taking the current coin */
                if (i + 1 < coins.length)
                    noTake = dp[j];
                
                /* Store the minimum of taking or not taking the coin */
                dp[j] = Math.min(take, noTake);
            }
        }
        
        /* Return the minimum coins needed for the target sum 
        or -1 if not possible */
        return dp[sum] != Integer.MAX_VALUE ? dp[sum] : -1;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
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
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends