class Solution {

    public static void solution(int[] arr, List<List<Integer>> ans, ArrayList<Integer> current, int index) {

        if(index == arr.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        // Take
        current.add(arr[index]);
        solution(arr, ans, current, index + 1);

        // Backtrack
        current.remove(current.size() - 1);

        // Not take
        solution(arr, ans, current, index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        solution(nums, ans, current, 0);

        return ans;
    }
}