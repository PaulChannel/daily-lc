package com.yougen.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2465. 不同的平均值数目
 *
 * @author: yougen.hu
 * @time: 2023/6/4 11:59
 */

public class LC_230604 {

  class Solution {

    public int distinctAverages(int[] nums) {
      Arrays.sort(nums);
      Set<Integer> count = new HashSet();

      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
        count.add(nums[left] + nums[right]);
        left++;
        right--;
      }
      return count.size();

    }
  }

  public static void main(String[] args) {
    int a = 10;
    int b = 11;
    double avg = (double) (a + b) / 2;
    System.out.println(avg);
  }
}
