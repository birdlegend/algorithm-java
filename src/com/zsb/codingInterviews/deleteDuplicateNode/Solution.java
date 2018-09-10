package com.zsb.codingInterviews.deleteDuplicateNode;

/**
 * created by zsb on 2018/9/10
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
        return val + " " + next + " ";
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode preN = null;
        ListNode curN = pHead;

        while (curN != null) {
            boolean delete = false;
            ListNode nextN = curN.next;
            // find first duplicate num
            delete = curN.next != null && curN.val == nextN.val;

            if (!delete) {
                preN = curN;
                curN = curN.next;
            } else {
                while (nextN != null && curN.val == nextN.val) {
                    nextN = nextN.next;
                }

                if (preN == null) {
                    pHead = nextN;
                } else {
                    preN.next = nextN;
                }
                curN = nextN;
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n7 = new ListNode(5);
        ListNode n6 = new ListNode(4, n7);
        ListNode n5 = new ListNode(4, n6);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(n1);
        System.out.println(solution.deleteDuplication(n1));
    }
}
