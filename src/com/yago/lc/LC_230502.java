package com.yago.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yougen.hu
 * @time: 2023/5/2 23:37
 */

public class LC_230502 {
    class Solution {
        public boolean checkInt(double x) {
            if (x % (int) x == 0) {
                return true;
            } else {
                return false;
            }
        }

        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();
            if (x == 1 && y == 1) {
                if (2 <= bound) {
                    set.add(2);
                }
            } else if (x == 1 || y == 1) {
                int j = (x == 1 ? y : x);
                for (int i = 0; Math.pow(j, i) < bound; ++i) {
                    double num = Math.pow(j, i) + 1;
                    if (checkInt(num)) {
                        set.add((int) num);
                    }
                }
            } else {

                for (int i = 0; Math.pow(x, i) < bound; ++i) {
                    for (int j = 0; ; ++j) {
                        double num = Math.pow(x, i) + Math.pow(y, j);
                        if (num > bound) {
                            break;
                        }
                        if (checkInt(num)) {
                            set.add((int) num);
                        }
                    }
                }
            }

            return new ArrayList<Integer>(set);
        }
    }
}
