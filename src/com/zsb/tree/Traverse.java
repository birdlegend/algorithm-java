package com.zsb.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by zsb on 2018/4/8.
 */

class Node {
    int val;
    Node left;
    Node right;
}

public class Traverse {

    public void visit(Node node) {
    }

    public void preOrder(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node p = null;

        while (p != null || !s.isEmpty()) {
            p = s.peek();
            s.pop();

            if (p.right != null)
                s.push(p);
            if (p.left != null)
                s.push(p);
        }
    }

    public void midOrder(Node root) {
        Stack<Node> s = new Stack<>();
        Node p = root;

        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.peek();
                s.pop();

                visit(p);

                p = p.right;
            }
        }
    }

    /**
     * 双链表实现后续遍历
     *
     * @param root
     */
    public void postOrder(Node root) {
        Stack<Node> traverse = new Stack<>();
        Stack<Node> visit = new Stack<>();
        Node p = null;
        traverse.push(root);

        while (p != null || !traverse.isEmpty()) {
            p = traverse.peek();
            traverse.pop();

            visit.push(p);

            // 右版前序遍历
            if (p.left != null)
                traverse.push(p.left);
            if (p.right != null)
                traverse.push(p.right);
        }

        while (!visit.isEmpty()) {
            visit(visit.pop());
        }
    }

    //分层打印节点，每一行为一层，返回该二叉树的层数  
    int depthTrase(Node node) {
        List<Node> list = new ArrayList<>();
        int rear = 0; //该层结束节点下标
        int front = 0;//该层的开始节点下标 
        int level = 0; // 层次数
        int last = 1; //所有已经遍历的节点的个数

        list.add(node);
        Node cur = null;
        while (rear < list.size()) {
            cur = list.get(rear);
            rear++;

            if (cur.left != null)
                list.add(cur.left);
            if (node.right != null)
                list.add(cur.right);

            //打印每一层节点  
            if (rear >= last) { //已遍历到该层最后一个节点
                // 输出当前层的节点
                for (int i = front; i < list.size(); i++) {
                    System.out.print(list.get(front));
                }

                System.out.println();

                front = rear;
                last = list.size();

                //
                level++;
            }
        }


        return 0;
    }

    void printPath(Stack<Integer> path) {


    }

    // 寻找某一特定子节点
    // https://blog.csdn.net/liuyi1207164339/article/details/50908308
    void findPath(Node root, List<Integer> path, int target) {
        if (root == null)
            return;

        path.add(root.val);
        if (root.val == target) {
            System.out.println(Arrays.toString(path.toArray()));
            return;
        }

        findPath(root.left, path, target);
        findPath(root.right, path, target);

        // 删除当前节点
        path.remove(path.size() - 1);
    }
}
