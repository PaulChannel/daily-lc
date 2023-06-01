package com.yago.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 * @author: yougen.hu
 * @time: 2023/4/20 20:35
 */

public class LC_230420 {

  class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
      int n = arr1.length;
      int m = arr2.length;
      Arrays.sort(arr2);
      List<Integer> list = new ArrayList();

      list.add(arr2[0]);
      for(int i = 1; i<m; ++i) {
        if(arr2[i] != arr2[i-1]) {
          list.add(arr2[i]);
        }
      }
      int[][] dp = new int[n+1][Math.min(n ,list.size()) + 1];
      for(int i = 0; i < dp.length; ++i) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      dp[0][0] = -1;
      for(int i = 1; i <= n; ++i) {
        for(int j = 0; j <= Math.min(i, list.size()); ++j) {
          if(arr1[i-1] > dp[i-1][j]) {
            dp[i][j] = arr1[i-1];
          }
          if(j > 0 && dp[i-1][j-1] != Integer.MAX_VALUE) {
            int index = binarySearch(list, dp[i-1][j-1],j-1);
            if(index != list.size()) {
              dp[i][j] = Math.min(dp[i][j], list.get(index));
              System.out.println(dp[i][j]);
            }
          }
          if(i == n && dp[i][j] != Integer.MAX_VALUE) {
            return j;
          }
        }
      }
      return -1;
    }

    public int binarySearch(List<Integer> list, int target, int low) {
      int r = list.size();
      int l = low;
      while(l < r) {
        int mid = (r - l) / 2 + l;
        int num = list.get(mid);
        if(num > target) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      return l;
    }
  }
}
