//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(int[] start, int[] finish) {
        
        int[][] interval = new int[start.length][2];
        for(int i=0; i<start.length; i++)  {
            interval[i][0] = finish[i];
            interval[i][1] = start[i];
        }
        
        /* Sort the intervals based on finish time in ascending order */
        Arrays.sort(interval,(a, b) -> Integer.compare(a[0], b[0]));
        
        int finishtime = -1, count = 0;
        for (int i=0; i<interval.length; i++) {
            
            /* If the start time of the current interval is 
            greater than the last finish time select this interval */
            if (interval[i][1] > finishtime) {
                
                /* Update the finish time to the current interval's finish time */
                finishtime = interval[i][0];
                count++;
            }
        }
        return count;
    }
}
