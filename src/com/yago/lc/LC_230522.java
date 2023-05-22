package com.yago.lc;

/**
 * 1080. 根到叶路径上的不足节点
 *
 * @author: yougen.hu
 * @time: 2023/5/22 20:36
 */

public class LC_230522 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
      boolean b = dfs(root, 0, limit);
      return b ? root : null;
    }

    public boolean dfs(TreeNode root, int sum, int limit) {
      if (root == null) {
        return false;
      }
      sum += root.val;
      if (root.left == null && root.right == null) {
        return sum >= limit;
      }
      boolean l = dfs(root.left, sum, limit);
      boolean r = dfs(root.right, sum, limit);
      if (l == false) {
        root.left = null;
      }

      if (r == false) {
        root.right = null;
      }
      return l || r;
    }
  }
}
