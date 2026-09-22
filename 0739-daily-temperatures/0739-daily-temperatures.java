import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        // Stack stores indices of temperatures that are still waiting for a warmer day.
        Stack<Integer> stk = new Stack<>();

        // Java initializes all int values to 0. If no warmer day is found, the answer remains 0.
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            // If today's temperature is warmer than the temperature at the index on top of the stack, we have found the next warmer day for that index.
            while (!stk.isEmpty()
                    && temperatures[i] > temperatures[stk.peek()]) {

                // Remove the previous day whose answer is now known.
                int prevIndex = stk.pop();

                // Number of days waited = current index - previous index.
                ans[prevIndex] = i - prevIndex;
            }

            // Current day is now waiting for a warmer future day.
            stk.push(i);
        }

        // Any indices still in the stack have no warmer
        // temperature in the future, so their answer remains 0.
        return ans;
    }
}