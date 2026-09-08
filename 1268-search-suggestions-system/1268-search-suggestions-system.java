class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        StringBuilder sb = new StringBuilder();
        List<List<String>> ans = new ArrayList<>();


        for(char ch : searchWord.toCharArray()){
            ArrayList<String> list = new ArrayList<>();
            sb = sb.append(ch);

            for(String str : products){
                if(str.startsWith(sb.toString())){
                    list.add(str);
                }
                if(list.size() == 3) break;
            }
            ans.add(list);
        }
        return ans;
        
    }
}