package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/13
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class MirrorBT {
    /*
    题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
     */

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }

}
