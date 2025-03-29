//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        
        int n = deadline.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        
        /* Pair the profit and deadline of all the jobs together */
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }

        /* Sort the jobs based on deadline in ascending order */
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        
        /* Min-heap to maintain the scheduled jobs based on profit */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] job : jobs) {
            
            /* If job can be scheduled within its deadline */
            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } 
            
            /* Replace the job with the lowest profit */
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }

        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends