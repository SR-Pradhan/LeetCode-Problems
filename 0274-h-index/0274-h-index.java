class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        for(int i = 0; i < n; i++){
            int remPaper = n - i;
            if(citations[i] >= remPaper) return remPaper;
        }
        return 0;
    }
}