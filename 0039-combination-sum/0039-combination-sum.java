class Solution {
    public static void solution(int[] arr, List<List<Integer>> ans, ArrayList<Integer> current, int target, int index){
        int n = arr.length;

        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || index == n){
            return;
        }

        //take
        current.add(arr[index]);
        // take → stay at same index
        solution(arr, ans, current,  target - arr[index], index);

        //backtrack
        current.remove(current.size() - 1);


        // not take → move forward
        solution(arr, ans, current, target, index + 1);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        solution(candidates, ans, current, target, 0);

        return ans;
    }
}