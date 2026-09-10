class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;

        for(int num: nums1){
            set.add(num);
        }

        for(int num: nums2){
            if(set.contains(num)){
                min = Math.min(min, num);
            }
        }

        if(min != Integer.MAX_VALUE) return min;

        else return -1;
        
    }
}