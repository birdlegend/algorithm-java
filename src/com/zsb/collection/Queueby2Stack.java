package com.zsb.collection;

import java.util.Stack;

/**
 * Created by zsb on 2018/3/24.
 */
public class Queueby2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>(); //辅助

    public void push(int node) {
       stack1.push(node);
    }

    public int pop() {

        while (!stack1.isEmpty() )
            stack2.push(stack1.pop());

        int res = stack2.pop();

        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

        return res;
    }
}