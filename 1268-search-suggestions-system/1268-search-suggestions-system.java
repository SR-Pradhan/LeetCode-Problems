class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> ans = new ArrayList<>();

        // Sort products lexicographically
        Arrays.sort(products);

        StringBuilder prefix = new StringBuilder();

        // Build the prefix one character at a time
        for (char ch : searchWord.toCharArray()) {

            prefix.append(ch);

            ArrayList<String> result = new ArrayList<>();

            // Find products matching the current prefix
            for (String str : products) {

                if (str.startsWith(prefix.toString())) {
                    result.add(str);
                }

                // We only need 3 suggestions
                if (result.size() == 3) {
                    break;
                }
            }

            // Store suggestions for the current prefix
            ans.add(result);
        }

        return ans;
    }
}