package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/13
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

public class MergeLink {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode pMergeHead;

        if(list1.val >= list2.val) {
            pMergeHead = list2;
            pMergeHead.next = Merge(list1, list2.next);
        } else {
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next, list2);
        }
        return pMergeHead;
    }
}