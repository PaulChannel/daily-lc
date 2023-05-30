package com.yougen.lc;

/**
 * 2455. 可被三整除的偶数的平均值
 *
 * @author: yougen.hu
 * @time: 2023/5/29 22:35
 */

public class LC_230529 {

  class Solution {

    public int averageValue(int[] nums) {
      int sum = 0;
      int count = 0;
      for (int i = 0; i < nums.length; ++i) {
        if (nums[i] % 6 == 0) {
          sum += nums[i];
          count++;
        }
      }
      return count == 0 ? 0 : sum / count;
    }
  }
}
