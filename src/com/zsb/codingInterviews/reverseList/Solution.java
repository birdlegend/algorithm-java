package com.zsb.codingInterviews.reverseList;

import java.util.List;

/**
 * created by zsb on 2018/9/12
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode preN = null;
        ListNode curN = head;
        ListNode nextN = null;

        while (curN != null) {
            nextN = curN.next;
            curN.next = preN;
            preN = curN;
            curN = nextN;
        }

        return preN;
    }
}
