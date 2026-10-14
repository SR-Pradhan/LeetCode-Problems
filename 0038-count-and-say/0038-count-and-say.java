class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int j = 0;

            while (j < result.length()) {
                char digit = result.charAt(j);
                int count = 0;

                while (j < result.length() && result.charAt(j) == digit) {
                    count++;
                    j++;
                }

                current.append(count);
                current.append(digit);
            }

            result = current.toString();
        }

        return result;
    }
}