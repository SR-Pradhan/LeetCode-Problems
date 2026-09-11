class Solution {

    String[] letters = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, "", result);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String current,
        List<String> result
    ) {

        // We have selected one letter for every digit
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters corresponding to current digit
        String possibleLetters =
            letters[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : possibleLetters.toCharArray()) {

            backtrack(
                digits,
                index + 1,
                current + ch,
                result
            );
        }
    }
}