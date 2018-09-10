package com.zsb.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 * 目前采用双向列表和哈希，之后优化可能改为双向循环列表，即采用head.prev代表尾节点
 * Created by zsb on 2018/4/16.
 */
class LRUCache {
    private Map<Integer, DoubleLinkedListNode> map = new HashMap<>();
    private int capacity;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int len;

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 将key放到链表头
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);

            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 将key放到链表头
            DoubleLinkedListNode node = map.get(key);
            node.val = value;

            removeNode(node);
            setHead(node);
        } else {
            // 新建node，插入表头，增加len。
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            setHead(node);

            if (len < capacity) {
                len++;
            }
            else {
                // 先map删除，再从链表中移除该节点
                map.remove(end.key);
                removeNode(end);
            }

            map.put(key, node);
        }
    }

    /**
     * 删除节点
     *
     * @param node
     */

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode next = node.next;

        if (pre == null) // node为头结点
            head = node.next;
        else
            pre.next = next;

        if (next == null)
            end = pre;
        else
            next.pre = pre;

    }

    /**
     * 设置头部
     *
     * @param node
     */
    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;

        if (head != null)
            head.pre = node;
        if (end == null)
            end = node;

        head = node; //todo 待验证
    }
}


class DoubleLinkedListNode {
    public int key;
    public int val;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */