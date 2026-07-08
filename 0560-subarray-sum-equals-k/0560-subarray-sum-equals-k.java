class Solution {
    public int subarraySum(int[] nums, int k) {
         int count = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int x : nums) {
            currSum += x;
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}