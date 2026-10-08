class Solution {
    public void helper(List<List<Integer>> ans, ArrayList<Integer> current, int[] arr, int index, int n){

        if(index == n){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        current.add(arr[index]);
        helper(ans, current, arr, index + 1, n);
        current.remove(current.size() - 1);
        helper(ans, current, arr, index + 1, n);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        
        int n = nums.length; 
        helper(ans, current, nums, 0, n); 
        return ans;
        
    }
}