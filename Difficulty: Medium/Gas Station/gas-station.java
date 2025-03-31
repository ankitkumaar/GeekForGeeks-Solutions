//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            // ArrayList<Integer> v = new ArrayList<Integer>();
            int[] gas = new int[array1.size()];
            int idx = 0;
            for (int i : array1) gas[idx++] = i;

            int[] cost = new int[array2.size()];
            idx = 0;
            for (int i : array2) cost[idx++] = i;

            int ans = new Solution().startStation(gas, cost);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int startStation(int[] gas, int[] cost) {
        
        int n = gas.length;
        int startIdx = 0;

        /* Initially car tank is empty */
        int currGas = 0;

        for (int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];

            /* If currGas becomes less than zero, then
            It's not possible to proceed with this startIdx */
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }

        /* Checking if startIdx can be a valid 
    	Starting point for the Circular tour */
        currGas = 0;
        for (int i = 0; i < n; i++) {

            /* Circular Index */
            int idx = (i + startIdx) % n;
            currGas = currGas + gas[idx] - cost[idx];
            
            if (currGas < 0)
                return -1;
        }
        return startIdx;
    }
}
