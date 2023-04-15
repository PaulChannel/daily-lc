package com.yougen.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hustart1@126.com
 * @version 1.0.0
 * @ClassName Main
 * @Description
 * @createTime 2023年04月15日 17:47:00
 */
public class LC_230415 {


	public int[] gardenNoAdj(int n, int[][] paths) {
		// 定义邻接表
		List<Integer>[] adj = new List[n];
		for (int i = 0; i < n; ++i) {
			adj[i] = new ArrayList<Integer>();
		}
		// 构建邻接表
		for (int[] path : paths) {
			int i = path[0], j = path[1];
			adj[i - 1].add(j - 1);
			adj[j - 1].add(i - 1);
		}
		int[] ans = new int[n];

		for (int i = 0; i < n; ++i) {
			boolean[] color = new boolean[5];
			for (int v : adj[i]) {
				if (ans[v] != 0) {
					color[ans[v]] = true;
				}
			}
			for (int j = 1; j <= 4; ++j) {
				if (!color[j]) {
					ans[i] = j;
					break;
				}
			}
		}
		return ans;
	}


}
