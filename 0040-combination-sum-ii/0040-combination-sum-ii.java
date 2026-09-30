class Solution {

    public void solution(int[] arr, List<List<Integer>> ans,
                         ArrayList<Integer> current, int index, int target) {

        int n = arr.length;

        // Valid combination found
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        // Invalid path
        if(target < 0 || index == n){
            return;
        }

        for(int i = index; i < n; i++){

            // Array is sorted, so remaining values are too large
            if(arr[i] > target){
                break;
            }

            // Skip duplicate choices at the same level
            if(i > index && arr[i] == arr[i - 1]){
                continue;
            }

            // Choose current candidate
            current.add(arr[i]);

            // Move forward: each element can be used once
            solution(arr, ans, current, i + 1, target - arr[i]);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        solution(candidates, ans, current, 0, target);

        return ans;
    }
}