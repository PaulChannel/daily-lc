package com.yago.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: yougen.hu
 * @time: 2023/5/19 20:42
 */

public class LC_230519 {

  class Solution {

    public int numTilePossibilities(String tiles) {
      Map<Character, Integer> map = new HashMap();
      for (int i = 0; i < tiles.length(); ++i) {
        map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0) + 1);
      }
      Set<Character> set = new HashSet<>(map.keySet());
      return dfs(map, set, tiles.length()) - 1;
    }

    public int dfs(Map<Character, Integer> map, Set<Character> set, int i) {
      if (i == 0) {
        return 1;
      }
      int res = 1;
      for (char c : set) {
        if (map.get(c) > 0) {
          map.put(c, map.get(c) - 1);
          res += dfs(map, set, i - 1);
          map.put(c, map.getOrDefault(c, 0) + 1);
        }
      }
      return res;
    }
  }
}
