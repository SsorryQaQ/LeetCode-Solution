/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i > -1; i--) {
            for (int j = p.length(); j > -1; j--) {
                if (i == s.length() && j == p.length()) { continue; }

                boolean firstMatch = i < s.length() && j < p.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*');
                if (j < p.length() && p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j+1] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

