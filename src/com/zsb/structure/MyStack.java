package com.zsb.structure;

import java.util.Arrays;
import java.util.Set;

/**
 * 参考 http://www.cnblogs.com/yangecnu/p/Introduction-Stack-and-Queue.html
 * 算法（第4版）源码：https://algs4.cs.princeton.edu/code/
 * Created by zsb on 2018/3/19.
 */

class Node<T> {
    private T Item;
    private Node Next;

    public T getItem() {
        return Item;
    }

    public void setItem(T item) {
        Item = item;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
public class MyStack<T> {
    private Node fist;
    private int num;

    public void push(final T Node) {
        T item[] = (T[]) new Object[3];
//        Arrays.copyOf()

    }

}
