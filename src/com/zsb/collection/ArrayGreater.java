package com.zsb.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个乱序整形数组，找出每个元素第一个索引比他大，且值比它大的元素。
 * 如输入：{3, 1, 4, 5, 3}, 输出{3:4, 1:4, 4:5}，如果找不到就输出-1。
 * Created by zsb on 2018/4/1.
 */
class Node {
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (key != node.key) return false;
        return val == node.val;

    }

    @Override
    public int hashCode() {
        int result = key;
        result = 31 * result + val;
        return result;
    }

    @Override
    public String toString() {
        return key + " : " + val;
    }
}

public class ArrayGreater {


    /**
     * 使用栈实现，遍历数组，将未找到的更大值的元素压入栈，如果栈顶小于当前元素，就弹出栈顶，并将当前元素与新的栈顶进行比较，
     * 循环比较直到栈为空，或者当前元素为数组末尾。
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 1, 4, 5, 3};
        int[] arr = new int[]{5, 3, 3, 4, 6, 3, 9, 7};


        Stack<Integer> stack = new Stack<>();

        List<Node> resList = new ArrayList<>();

        stack.push(arr[0]);
        int i = 1;
        while (i < arr.length) {
            if (!stack.isEmpty() && stack.peek() < arr[i]) {
                Node node = new Node(stack.pop(), arr[i]);

                // // TODO: 2018/4/1 去重
                if (!resList.contains(node))
                    resList.add(node);
            } else {
                stack.push(arr[i]);
                i++;
            }
        }

        for (Node node : resList) {
            System.out.println(node);
        }

    }

}
