class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for(int i = 0; i < strs.length; i++){
            ArrayList<String> current = new ArrayList<>();
            char[] ch1 = strs[i].toCharArray();
            Arrays.sort(ch1);

            if (visited[i]) continue;
            
            for(int j = 0; j < strs.length; j++){
                char[] ch2 = strs[j].toCharArray();
                Arrays.sort(ch2);

                if(visited[j] == true) continue;

                if(Arrays.equals(ch1, ch2)){
                    visited[j] = true;
                    current.add(strs[j]);
                }  
            }
            ans.add(current);
        }

        return ans;
    }
}