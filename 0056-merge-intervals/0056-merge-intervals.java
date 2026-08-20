class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();

        // Sort intervals by their starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;

        while (i < n) {

            // Current interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // Merge all overlapping intervals
            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            // Store the merged interval
            ans.add(new int[]{start, end});

            // Move to the first unprocessed interval
            i = j;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}