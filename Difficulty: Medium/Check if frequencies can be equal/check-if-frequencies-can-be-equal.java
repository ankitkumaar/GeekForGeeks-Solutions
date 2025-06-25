class Solution {
    boolean sameFreq(String s) {
        /* Count frequency of each character */
        int[] freq = new int[26];
        for (char ch : s.toCharArray())   {
            freq[ch - 'a']++;
        }

        /* Find the maximum and minimum non-zero frequencies */
        int max = 0, min = Integer.MAX_VALUE;
        for (int num : freq)   {
            max = num > max ? Math.max(num, max) : max;
            min = (num < min) && (num != 0) ? Math.min(num, min) : min;
        }

        /* Count how many characters have each frequency */
        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int f : freq) {
            if (f > 0) {
                countFreq.put(f, countFreq.getOrDefault(f, 0) + 1);
            }
        }

        /* If all characters have the same frequency, return true */
        if (countFreq.size() == 1) return true;

        /* If more than 2 different frequencies, return false */
        if (countFreq.size() > 2) return false;

        /* Extract the two frequencies and their counts */
        List<Integer> keys = new ArrayList<>(countFreq.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = countFreq.get(f1), c2 = countFreq.get(f2);

        /* One character has frequency 1 and 
        appears only once → remove it */
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;

        /* Frequencies differ by 1 and 
        the higher one appears only once → reduce it */
        if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) return true;
        return false;
    }
}
