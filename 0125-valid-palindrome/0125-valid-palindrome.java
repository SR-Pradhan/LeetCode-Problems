class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        String str = s.toLowerCase();

        while (i < j) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(j))) {
                j--;
                continue;
            }

            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}