package com.yago.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:1016. 子串能表示从 1 到 N 数字的二进制串
 * @author: yougen.hu
 * @time: 2023/5/11 22:50
 */

public class LC_230511 {

  class Solution {

    public boolean queryString(String s, int n) {

      char[] arr = s.toCharArray();
      int m = s.length();
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < m; ++i) {
        int x = arr[i] - '0';
        if (x == 0) {continue;}
        for (int j = i + 1; x <= n; ++j) {

          set.add(x);
          if (j == m) {
            break;
          }
          x = (x << 1) | arr[j] - '0';
        }
      }

      return set.size() == n;
    }
  }
}
