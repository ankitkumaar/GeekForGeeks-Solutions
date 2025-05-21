class Solution {
    public int kthSmallest(int m, int n, int k) {
        int low = 1, high = m * n;

        /* Binary search to find the smallest number such that
        there are at least k numbers less than or equal to it */
        while (low < high) {
            int mid = low + (high - low) / 2;

            /* Count how many numbers are <= mid 
            in the multiplication table */
            int count = countLessEqual(mid, m, n);

            /* If count is less than k, discard the left half
            otherwise, continue searching in the left half */
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    /* function to count how many numbers are less than or 
    equal to 'mid' in an m x n multiplication table */
    private int countLessEqual(int mid, int m, int n) {
        int count = 0;

        /* For each row i (1 to m), count how many numbers in 
        that row are <= mid Each row i contains: i, 2i, 3i, ..., ni */
        for (int i = 1; i <= m; i++) {
            
            /* The number of elements in row i that are <= mid 
            is mid/i but it cannot exceed n (number of columns) */
            count += Math.min(mid / i, n);
        }
        return count;
    }
}
