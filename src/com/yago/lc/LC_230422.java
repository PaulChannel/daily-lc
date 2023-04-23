package com.yago.lc;

/**
 * @author yago.hu
 * @Description
 * @createTime 2023年04月23日 21:04:00
 */
public class LC_230422 {

	class Solution {

		public int longestArithSeqLength(int[] nums) {
			int ans = 0;
			// dp[i][diff] 表示以nums[i]结尾，d = diff 的数组长度
			int[][] dp = new int[nums.length][1001];
			for (int i = 1; i < nums.length; ++i) {
				for (int j = 0; j < i; ++j) {
					int diff = nums[i] - nums[j] + 500;
					dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
					ans = Math.max(ans, dp[i][diff]);
				}
			}
			return ans + 1;
		}
	}
}
