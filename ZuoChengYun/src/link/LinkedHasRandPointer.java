package link;

import java.util.HashMap;

/**
 * @Author: JonesYang
 * @Data: 2021-06-27
 * @Description: 一种特殊的链表，它有一个rand的指针，对于它的说明如： rand 是单链表节点中新增的指针，rand 可以指向链表中的任意一个节点，也可能指向 null。
 * <p>
 * 题目要求如下：
 * 给定一个由 Node 节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点
 */
public class LinkedHasRandPointer {

    /**
     * 需要使用 HashMap 创建额外的内存的空间
     *
     * @param head
     * @return 复制链表的新的头节点
     */
    private static Node copyListWIthRand(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 每一个旧链表的节点对应它新链表的节点
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        // 把复制的按照对应的关系链接起来
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 没有辅助的空间
     *
     * @param head
     * @return
     */
    private static Node copyListWIthRand1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 完成这个 while 之后，链表的状态类似这样 1 -> 1' -> 2 -> 2' -> 3 -> 3'，但是还没有完成 rand 的指向
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        // 完成 rand 指针的指向
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        // 分离两种链表,理解不清楚可以画图
        cur = head;
        Node newHead = cur.next;
        Node newCur = newHead;
        while (cur != null) {
            next = cur.next.next;
            newCur = cur.next;
            cur.next = next;
            newCur.next = next != null ? next.next : null;
            cur = cur.next;
        }

        return newHead;
    }

    /**
     * 链表节点的数据结构
     */
    static class Node {
        private int value;
        private Node next;
        private Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
}
