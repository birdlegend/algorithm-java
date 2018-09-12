package com.zsb.codingInterviews.findKtoTail;

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
    /**
     *
     * @param head
     * @param k >=1
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        if(k<1)
            return null;

        for (int i = 1; i < k && first != null; i++) {
            first = first.next;
        }

        if (first == null) {
            return null;
        }

        while (first.next != null) {
            second = second.next;
            first = first.next;
        }

        return second;
    }
}
