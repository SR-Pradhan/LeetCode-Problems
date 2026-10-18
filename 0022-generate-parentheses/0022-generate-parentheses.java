
class Solution {
    public void helper(int n, List<String> ans, StringBuilder sb, int open, int close) {

        // Base case: we have used all n pairs of parentheses
        if (sb.length() == 2 * n) {
            ans.add(sb.toString()); // Save the completed string
            return;                 // Return to the previous recursive call
        }

        // Choice 1: Add '(' if we haven't used all opening brackets
        if (open < n) {
            sb.append('('); // Make the choice

            // Explore this choice with one more opening bracket
            helper(n, ans, sb, open + 1, close);

            // Backtrack: undo the choice after the recursive call returns
            sb.deleteCharAt(sb.length() - 1);
        }

        // Choice 2: Add ')' only if an unmatched '(' is available
        if (close < open) {
            sb.append(')'); // Make the choice

            // Explore this choice with one more closing bracket
            helper(n, ans, sb, open, close + 1);

            // Backtrack: undo the choice after the recursive call returns
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // Start with an empty string and zero brackets used
        helper(n, ans, sb, 0, 0);

        return ans;
    }
}
