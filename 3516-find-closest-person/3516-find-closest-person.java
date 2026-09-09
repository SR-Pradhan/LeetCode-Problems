class Solution {
    public int findClosest(int x, int y, int z) {

        int dist1 = Math.max(x, z) - Math.min(x, z);
        int dist2 = Math.max(y, z) - Math.min(y, z);

        if(dist1 == dist2) return 0;

        if(Math.min(dist1, dist2) == dist1) return 1;
        else return 2;
    }
}