package com.yago.lc;


/**
 * @description: 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * @author: yougen.hu
 * @time: 2023/4/18 16:38
 */

public class LC_230418 {

  /**
   * Definition for a binary tree node.
   */
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

    class Solution {


      public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
      }

      public int dfs(TreeNode node, int min, int max) {
        if (node == null) {
          return 0;
        }
        int diff = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        diff = Math.max(diff, dfs(node.left, min, max));
        diff = Math.max(diff, dfs(node.right, min, max));
        return diff;
      }
    }

  }
}
