package com.yago.lc;

/**
 * 2432. 处理用时最长的那个任务的员工
 *
 * @author: yougen.hu
 * @time: 2023/5/5 22:21
 */

public class LC_2305005 {

  class Solution {

    public int hardestWorker(int n, int[][] logs) {
      int pre = 0;
      int ans = logs[0][1];
      int id = logs[0][0];
      for (int i = 1; i < logs.length; ++i) {
        if (logs[i][1] - logs[i - 1][1] > ans) {
          id = logs[i][0];
          ans = logs[i][1] - logs[i - 1][1];
        }
        if (logs[i][1] - logs[i - 1][1] == ans) {
          id = Math.min(id, logs[i][0]);
        }
      }
      return id;
    }
  }
}
