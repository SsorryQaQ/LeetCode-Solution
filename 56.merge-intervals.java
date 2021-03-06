/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null
        || intervals.length == 0
        || intervals[0] == null
        || intervals[0].length == 0) { return new int[0][]; }
        Comparator<int[]> intervalComparator = (a, b)-> {
            int cmp1 = Integer.compare(a[0], b[0]);
            if (cmp1 != 0) { return cmp1; }
            else { return Integer.compare(a[1], b[1]); }
        };
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, intervalComparator);
        int[] tmpArray = Arrays.copyOf(intervals[0], 2);
        for (int[] array : intervals) {
            if (array[0] > tmpArray[1]) {
                res.add(tmpArray);
                tmpArray = Arrays.copyOf(array, 2);
            } else {
                tmpArray[1] = Math.max(tmpArray[1], array[1]);
            }
        }
        res.add(tmpArray);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) { ans[i] = res.get(i); }
        return ans;
    }
}
// @lc code=end

