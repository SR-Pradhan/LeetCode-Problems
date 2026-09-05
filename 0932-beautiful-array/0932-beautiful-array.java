import java.util.*;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();

        // Start with [1]
        result.add(1);

        while (result.size() < n) {
            List<Integer> next = new ArrayList<>();

            // Generate odd numbers
            for (int x : result) {
                int odd = 2 * x - 1;

                if (odd <= n) {
                    next.add(odd);
                }
            }

            // Generate even numbers
            for (int x : result) {
                int even = 2 * x;

                if (even <= n) {
                    next.add(even);
                }
            }

            result = next;
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}