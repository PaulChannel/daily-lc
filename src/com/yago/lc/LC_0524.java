package com.yago.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 1377. T 秒后青蛙的位置
 *
 * @author: yougen.hu
 * @time: 2023/5/25 00:10
 */

public class LC_0524 {

  class Solution {

    public double frogPosition(int n, int[][] edges, int t, int target) {
      List<Integer>[] lists = new List[n + 1];
      boolean[] visited = new boolean[n + 1];

      for (int i = 1; i <= n; ++i) {
        lists[i] = new ArrayList();
      }
      for (int[] e : edges) {
        lists[e[0]].add(e[1]);
        lists[e[1]].add(e[0]);
      }

      return dfs(lists, visited, 1, t, target);

    }

    public double dfs(List<Integer>[] lists, boolean[] visited, int i, int t, int target) {
      int next = i == 1 ? lists[i].size() : lists[i].size() - 1;
      if (next == 0 || t == 0) {
        return i == target ? 1.0 : 0.0;
      }
      double ans = 0.0;
      visited[i] = true;
      for (int j : lists[i]) {
        if (!visited[j]) {
          ans += dfs(lists, visited, j, t - 1, target);
        }

      }
      return ans / next;
    }
  }

}
