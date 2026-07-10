class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j  = numbers.length - 1;

        while(i < j){
            int ans = numbers[j] + numbers[i];

            if(ans == target) return new int[]{i + 1, j + 1};

            if(ans < target) i++;
            else j--;
            
        }
        return new int[]{};
    }
}