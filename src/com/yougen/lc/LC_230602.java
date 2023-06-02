package com.yougen.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * 2559. 统计范围内的元音字符串数
 *
 * @author: yougen.hu
 * @time: 2023/6/2 22:58
 */

public class LC_230602 {

  class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
      int n = words.length;
      int[] count = new int[n + 1];
      Set<Character> set = new HashSet();
      set.add('a');
      set.add('e');
      set.add('i');
      set.add('o');
      set.add('u');
      int[] ans = new int[queries.length];
      count[0] = 0;
      for (int i = 1; i <= n; ++i) {
        String word = words[i - 1];
        if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
          count[i] = count[i - 1] + 1;
        } else {
          count[i] = count[i - 1];
        }
      }
      for (int i = 0; i < queries.length; ++i) {
        int[] area = queries[i];
        int l = queries[i][0];
        int r = queries[i][1];
        ans[i] = count[r + 1] - count[l];
      }
      return ans;
    }
  }
}
