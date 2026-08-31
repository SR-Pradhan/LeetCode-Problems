class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {

            if (log.equals("../")) {
                // Move to parent folder if possible
                if (depth > 0) {
                    depth--;
                }
            }
            else if (log.equals("./")) {
                // Stay in the current folder
                continue;
            }
            else {
                // Enter a new folder
                depth++;
            }
        }

        return depth;
    }
}