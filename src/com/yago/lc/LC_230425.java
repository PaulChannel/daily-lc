package com.yago.lc;

import java.util.Arrays;

/**
 * 2418. 按身高排序
 *
 * @author: yougen.hu
 * @time: 2023/4/25 22:05
 */

public class LC_230425 {

  class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
      int n = names.length;
      Integer[] indices = new Integer[n];
      for (int i = 0; i < n; i++) {
        indices[i] = i;
      }
      Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
      String[] res = new String[n];
      for (int i = 0; i < n; i++) {
        res[i] = names[indices[i]];
      }
      return res;
    }
  }

}
