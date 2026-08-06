class Solution {

    public int findDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Traverse the array
        for (int num : nums) {

            // Duplicate found
            if (set.contains(num)) {
                return num;
            }

            // Store the current number
            set.add(num);
        }

        // This line is never reached as the problem guarantees one duplicate
        return -1;
    }
}