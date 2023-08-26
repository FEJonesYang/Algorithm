package v2.link;

import utils.ListNode;

/**
 * 双向链表实现队列和栈
 */
public class DoubleEndQueue<T> {

    private ListNode<T> head;
    private ListNode<T> tail;

    private int size;

    public void addFromHead(ListNode<T> node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.last = node;
            node.next = head;
            // 先改变指向，再改变头结点
            head = node;
        }
        size++;
    }

    public void addFromTail(ListNode<T> node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
        size++;
    }

    public ListNode<T> removeFromTail() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据了");
        }
        ListNode<T> removeNode = tail;
        tail = tail.last;
        removeNode.last = null;
        tail.next = null;
        return removeNode;
    }

    public ListNode<T> removeFromHead() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据了");
        }
        ListNode<T> removeNode = head;
        head = head.next;
        head.last = null;
        return removeNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static class Stack<T> {
        DoubleEndQueue<T> stack = new DoubleEndQueue<>();

        public void pop(ListNode<T> node) {
            stack.addFromHead(node);
        }

        public ListNode<T> push() {
            return stack.removeFromHead();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

    }

    static class Queue<T> {
        DoubleEndQueue<T> queue = new DoubleEndQueue<>();

        public void add(ListNode<T> node) {
            queue.addFromHead(node);
        }

        public ListNode<T> remove() {
            return queue.removeFromTail();
        }
    }
}
