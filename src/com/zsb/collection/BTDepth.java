package com.zsb.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b
 * Created by zsb on 2018/4/1.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class BTDepth {
    // 递归实现
    public static int TreeDepth(TreeNode root) {
        // 递归实现
        return root != null ? Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1 : 0;
    }

    // 非递归实现
    public static int TreeDepth2(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 0, count = 0, nextCount = 1; // nextCount为当前节点的子节点的
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if(count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }

        }
        return depth;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preorderTravel(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderTravel(root.left);
        preorderTravel(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrderTravel(TreeNode root) {
        if (root == null)
            return;
        inOrderTravel(root.left);
        System.out.print(root.val + " ");
        inOrderTravel(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode cur;
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        cur = root.left;
        cur.left = new TreeNode(3);
        cur.right = new TreeNode(4);

        cur = cur.left;
        cur.left = new TreeNode(5);

        inOrderTravel(root);

    }
}
