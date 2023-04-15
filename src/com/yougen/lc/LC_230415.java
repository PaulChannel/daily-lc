package com.yougen.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hustart1@126.com
 * @version 1.0.0
 * @ClassName Main
 * @Description
 * 1042. 不邻接植花
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 *
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 *
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
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
