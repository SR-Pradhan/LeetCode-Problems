class Solution {
    public int passThePillow(int n, int time) {

        int cycle = 2 * (n - 1);
        int pos = time % cycle;

        if (pos < n) {
            return pos + 1;
        }

        return cycle - pos + 1;
    }
}