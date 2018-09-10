package com.zsb.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * <p>
 * 题目描述
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * <p>
 * Created by zsb on 2018/3/24.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkListReverse {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack stack = new Stack<ListNode>();

        int n = 0;
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
            n++;
        }

        ArrayList list = new ArrayList<Integer>(n);

        while (!stack.isEmpty())
            list.add(stack.pop());
        return list;
    }


    public static void main(String[] args) {
        ListNode first, cur, next;
        cur = new ListNode(1);
        first = cur;

        for (long i = 0; i < 10E5; i++) {
            next = new ListNode(1);
            cur.next = next;
            cur = next;
        }
        Date start = new Date();

        printListFromTailToHead(first);

        Date end = new Date();

        long interver = end.getTime() - start.getTime();
        System.out.println(interver);

    }
}
