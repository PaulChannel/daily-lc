package com.yago.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 *
 * @author: yougen.hu
 * @time: 2023/5/23 21:13
 */

public class LC_0523 {


  class Solution {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
      int n = values.length;
      Map<Integer, Integer> labelCount = new HashMap();
      int[][] arr = new int[n][2];
      for (int i = 0; i < n; ++i) {
        arr[i][0] = values[i];
        arr[i][1] = labels[i];
      }
      int ans = 0;
      int sum = 0;
      Arrays.sort(arr, (a, b) -> b[0] - a[0]);
      for (int i = 0; i < n; ++i) {
        if (sum >= numWanted) {
          break;
        }
        int count = labelCount.getOrDefault(arr[i][1], 0);
        if (count >= useLimit) {
          continue;
        }
        ans += arr[i][0];
        labelCount.put(arr[i][1], count + 1);
        sum++;
      }
      return ans;
    }
  }
}
