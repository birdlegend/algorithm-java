package com.zsb.codingInterviews.entryNodeOfLoop;

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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 判断环
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && (fast = fast.next) != null) {
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        // 找到环中的一个结点
        if (fast == null) {
            return null;
        }

        ListNode pNode = slow;
        int loopNum = 0; // 环中有多少个几点
        do {
            slow = slow.next;
            loopNum++;
        } while (slow != pNode);


        // 倒数第loopNum个结点
        ListNode first = pHead; // 先走loopNum个节点
        ListNode second = pHead;
        for (int i = 0; i < loopNum; i++) {
            first = first.next;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n6.next = n3;

        System.out.println(solution.EntryNodeOfLoop(n1));
    }
}
