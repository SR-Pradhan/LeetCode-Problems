class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();

        // Traverse the array and track numbers already seen.
        for (int number : nums) {

            // If the number is already present, it is a duplicate.
            if (set.contains(number)) {
                answer.add(number);
            } else {
                set.add(number);
            }
        }

        return answer;
    }
}