
import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        String[] str = paragraph.toLowerCase()
                                .replaceAll("[^a-z ]", " ")
                                .trim()
                                .split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));

        // Count the frequency of each non-banned word
        for (int i = 0; i < str.length; i++) {
            if (set.contains(str[i])) continue;

            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
        }

        // Find the word with the highest frequency
        int maxCount = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
