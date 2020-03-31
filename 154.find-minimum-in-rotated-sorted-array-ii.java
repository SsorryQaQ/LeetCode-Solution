/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > nums[end]) { begin = mid + 1; }
            else if (nums[mid] < nums[end]) { end = mid; }
            else { end--; }
        }
        return nums[begin];
    }
}
// @lc code=end
