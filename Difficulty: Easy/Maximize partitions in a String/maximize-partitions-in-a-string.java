//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        
        /* Array to store the last occurrence index of each character */
        int[] charAlpha = new int[26];
        
        /*Populate the array with the last index of each character */
        for(int i=0; i<s.length(); i++)  {
            charAlpha[s.charAt(i) - 'a'] = i;
        }
        
        /* Initialize variables to track the start and end of partitions */
        int partitionStart = 0, partitionEnd = 0;
        List<Integer> partitionSizes = new ArrayList<>();
        for(int i=0; i<s.length(); i++)   {
            partitionEnd = Math.max(partitionEnd, charAlpha[s.charAt(i) - 'a']);
            
            if(i == partitionEnd)   {
                partitionSizes.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return partitionSizes.size();
    }
}