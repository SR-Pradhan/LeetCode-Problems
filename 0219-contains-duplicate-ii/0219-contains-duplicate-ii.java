class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // If we've seen this number before
            if (map.containsKey(nums[i])) {
                
                // Check if the index difference is within k
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            // Update the latest index of the current number
            map.put(nums[i], i);
        }

        return false;
    }
}