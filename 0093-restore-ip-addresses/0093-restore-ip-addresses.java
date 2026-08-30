import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(
            String s,
            int index,
            int parts,
            StringBuilder current,
            List<String> result) {

        // We need exactly 4 parts
        if (parts == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        // Each IP segment can contain 1 to 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            // Example: "01" is invalid
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Value must be <= 255
            int value = Integer.parseInt(part);

            if (value > 255) {
                break;
            }

            // Choose
            current.append(part).append('.');

            // Explore
            backtrack(
                s,
                index + len,
                parts + 1,
                current,
                result
            );

            // Backtrack
            current.delete(
                current.length() - len - 1,
                current.length()
            );
        }
    }
}