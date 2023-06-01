package com.yago.lc;

import java.util.Stack;

/**
 * 1003. 检查替换后的词是否有效
 *
 * @author: yougen.hu
 * @time: 2023/5/3 15:05
 */


public class LC_230503 {

    /**
     * 暴力枚举
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            if (check(sb, i)) {
                StringBuilder replace = sb.replace(i, i + 2, "");
                return isValid(replace.toString());
            }
        }
        return false;
    }

    public boolean check(StringBuilder sb, int idx) {
        int n = sb.length();

        if (idx >= n - 2) {
            return false;
        }
        return sb.charAt(idx + 2) - sb.charAt(idx + 1) == sb.charAt(idx + 1) - sb.charAt(idx) && sb.charAt(idx + 1) - sb.charAt(idx) == 1;
    }


    /**
     * 栈模拟
     *
     * @param s
     * @return
     */

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
