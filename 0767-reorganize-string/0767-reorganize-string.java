import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max heap: [character, frequency]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            // Pick two different characters
            result.append((char) ('a' + first[0]));
            result.append((char) ('a' + second[0]));

            first[1]--;
            second[1]--;

            // Put them back if they still have remaining occurrences
            if (first[1] > 0) {
                pq.offer(first);
            }

            if (second[1] > 0) {
                pq.offer(second);
            }
        }

        // If one character is left, it must occur only once
        if (!pq.isEmpty()) {
            int[] last = pq.poll();

            if (last[1] > 1) {
                return "";
            }

            result.append((char) ('a' + last[0]));
        }

        return result.toString();
    }
}