class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push the expected closing bracket
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                // Closing bracket: check if it matches the expected bracket
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched brackets remain
        return stack.isEmpty();
    }
}