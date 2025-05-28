import java.util.*;

class Solution {
    public boolean ValidCorner(int[][] mat) {
        
        /* Set to store pairs of columns 
        where 1s have been seen in previous rows */
        Set<String> setPair = new HashSet<>();
        
        /* Iterate through each row of the matrix */
        for (int i = 0; i < mat.length; i++) {
            
            /* For each row, check all pairs of columns */
            for (int j = 0; j < mat[0].length - 1; j++) {
                
                /* If there's a 1 at position (i, j) */
                if (mat[i][j] == 1) {
                    
                    /* Check for another 1 
                    in the same row but in a later column */
                    for (int k = j + 1; k < mat[0].length; k++) {
                        
                        /* If there's a 1 at position (i, k) again */
                        if (mat[i][k] == 1) {
                            String str = j + "," + k;
                            
                            /* If this column pair has been seen 
                            in a previous row, a rectangle is formed */
                            if (setPair.contains(str))
                                return true;
                            
                            /* Otherwise, store 
                            this column pair for future rows */
                            setPair.add(str);
                        }
                    }
                }
            }
        }
        return false;
    }
}
