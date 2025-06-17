class Solution {
    public int minimumCoins(int[] arr, int k) {
        
        /* Sort the array to make it easier to process ranges */
        Arrays.sort(arr); 
        int n = arr.length;

        /* Create a prefix sum array to quickly calculate 
        sum of coins in any range */
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        /* To store the minimum coins to remove
        Sum of coins in piles smaller than current base pile */
        int ans = Integer.MAX_VALUE;
        int prev = 0;

        /* Try each unique pile value as the base 
        (minimum pile to keep) */
        for (int i = 0; i < n; i++) {
            
            /* Skip duplicate values to avoid redundant calculations */
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            /* Update prefix sum of coins before index i */
            if (i > 0)
                prev = prefix[i - 1];

            /* Find the first pile that exceeds arr[i] + k */
            int pos = upperBound(arr, arr[i] + k, i, n);

            /* Calculate total coins to remove */
            int totalToRemove = prev;
            
            /* Remove excess coins from piles greater than arr[i] + k */
            if (pos < n) {
                totalToRemove += prefix[n - 1] - prefix[pos - 1] - 
                                 (n - pos) * (arr[i] + k);
            }

            /* Update the minimum result */
            ans = Math.min(ans, totalToRemove);
        }

        return ans;
    }

    /* Helper function to find the first index where arr[index] > key */
    private static int upperBound(int[] arr, int key, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
