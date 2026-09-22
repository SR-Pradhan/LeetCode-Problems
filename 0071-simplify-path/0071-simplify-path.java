import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {

            // Ignore empty parts and current directory "."
            if (parts[i].equals("") || parts[i].equals(".")) {
                continue;
            }

            // Go to the parent directory
            else if (parts[i].equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }

            // Normal directory
            else {
                stk.push(parts[i]);
            }
        }

        // Build the simplified path
        for (String str : stk) {
            ans.append("/").append(str);
        }

        // Empty stack means root directory
        return ans.length() == 0 ? "/" : ans.toString();
    }
}