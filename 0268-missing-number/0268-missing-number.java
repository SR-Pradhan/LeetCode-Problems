class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        for(int j = 0; j <= n; j++){
            if(!set.contains(j)) return j;
        }
        return -1;
    }
}