package com.yago.lc;

import java.util.Arrays;

/**
 * @author yago.hu
 * @Description
 * @createTime 2023年04月23日 20:06:00
 */
public class LC_230423 {

	class Solution {

		public int minHeightShelves(int[][] books, int shelfWidth) {
			int n = books.length;
			int dp[] = new int[n + 1];
			Arrays.fill(dp, 1000000);
			dp[0] = 0;
			for (int i = 0; i < n; ++i) {
				int w = 0, maxH = 0;
				for (int j = i; j >= 0; --j) {
					w += books[j][0];
					if (w > shelfWidth) {
						break;
					}
					maxH = Math.max(maxH, books[j][1]);
					dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxH);
				}
			}
			return dp[n];
		}
	}

}
