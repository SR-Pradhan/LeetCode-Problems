class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int left = 0;
        int right = 0;

        for(int i = 0; i < n; i++){
            freq1[s1.charAt(i) - 'a']++;
        }

        while(right < s2.length()){
            freq2[s2.charAt(right) - 'a']++;
            right++;

            if(right - left > n){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if(right - left == n){
                if(Arrays.equals(freq1, freq2)) return true;
            }
        }
        return false;
        
    }
}