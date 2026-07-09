class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }
            int j = i;

            // Find beginning of current word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Add space before every word except the first
            if (ans.length() > 0) {
                ans.append(' ');
            }

            // Copy current word
            for (int k = j + 1; k <= i; k++) {
                ans.append(s.charAt(k));
            }

            i = j;
        }

        return ans.toString();
    }
}