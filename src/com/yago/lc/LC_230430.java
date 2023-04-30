package com.yago.lc;

import java.util.Arrays;

/**
 * 1033. 移动石子直到连续
 *
 * @author: yougen.hu
 * @time: 2023/4/30 13:32
 */

public class LC_230430 {

  class Solution {

    public int[] numMovesStones(int a, int b, int c) {
      int[] pos = new int[3];
      pos[0] = a;
      pos[1] = b;
      pos[2] = c;
      Arrays.sort(pos);
      int[] ans = new int[2];
      ans[1] = pos[2] - pos[0] - 2;
      if (pos[1] - pos[0] == 1 && pos[2] - pos[1] == 1) {
        ans[0] = 0;
      } else if ((pos[1] - pos[0] == 1 || pos[2] - pos[1] == 1) || (pos[1] - pos[0] == 2 || pos[2] - pos[1] == 2)) {
        ans[0] = 1;
      } else {
        ans[0] = 2;
      }
      return ans;
    }
  }
}
