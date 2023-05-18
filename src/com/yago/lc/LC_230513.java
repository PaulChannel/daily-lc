package com.yago.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 2441. 与对应负数同时存在的最大正整数
 * @author: yougen.hu
 * @time: 2023/5/13 15:54
 */

public class LC_230513 {

  class Solution {

    public int findMaxK(int[] nums) {
      Set<Integer> set = new HashSet();
      int ans = -1;
      for (int num : nums) {
        set.add(num);
        if (set.contains(-num)) {
          ans = Math.max(ans, Math.abs(num));
        }
      }
      return ans;
    }
  }
}
