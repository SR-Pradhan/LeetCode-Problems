class Solution {
    public static int signFunc(long x){
        if(x > 0) return 1;
        else if(x < 0) return -1;
        else return 0;
    }

    public int arraySign(int[] nums) {
        long x = 1;

        for(int num : nums){
            if(num == 0) return signFunc(0);

            if(num < 0) x *= -1;
        }

        return signFunc(x);
    }
}