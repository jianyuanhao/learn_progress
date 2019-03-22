package com.joy.fresh.test.leecode;

/**
 * Created by jianyuanhao on 18-5-1.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        List<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode r = root;
        while (root != null || !stack.isEmpty()) {
            while (r != null) {
                // 遍历当前节点左子树
                stack.add(r);
                r = r.left;
            }
            if (!stack.isEmpty()) {
                TreeNode t = stack.remove(0);
                ret.add(t.val);
                r = t.right;
            }
        }
        return ret;
    }
}
