class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> ans = new ArrayList<>();

        // Sort products lexicographically
        Arrays.sort(products);

        StringBuilder prefix = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {

            prefix.append(ch);
            String currentPrefix = prefix.toString();

            int low = 0;
            int high = products.length;

            // Find the first product >= currentPrefix
            while (low < high) {

                int mid = low + (high - low) / 2;

                if (products[mid].compareTo(currentPrefix) < 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            // Collect up to 3 matching products
            List<String> result = new ArrayList<>();

            for (int i = low; i < products.length; i++) {

                if (products[i].startsWith(currentPrefix)) {
                    result.add(products[i]);
                }

                if(result.size() == 3) break;
            }

            ans.add(result);
        }

        return ans;
    }
}