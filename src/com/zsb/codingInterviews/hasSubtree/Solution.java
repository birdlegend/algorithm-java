package com.zsb.codingInterviews.hasSubtree;

/**
 * created by zsb on 2018/9/12
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

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val) {
            result = tree1ContainTree2(root1, root2);
        }

        if (!result) {
            result = HasSubtree(root1.left, root2);
        }

        if (!result) {
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    public boolean tree1ContainTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null)
            return false;

        return root1.val == root2.val &&
                tree1ContainTree2(root1.left, root2.left) &&
                tree1ContainTree2(root1.right, root2.right);
    }
}
