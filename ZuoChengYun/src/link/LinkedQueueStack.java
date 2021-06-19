package link;

/**
 * @Author: JonesYang
 * @Data: 2021-06-18
 * @Description:左程云算法课，使用双向链表实现队列、栈 这是一个双链表实现的，支持头部添加删除元素，也支持尾部添加元素。
 * 栈的实现只需要往头部添加元素，往头部删除元素；队列实现只需要实现头部添加，尾部删除
 */
public class LinkedQueueStack<T> {

    // 头节点
    private Node<T> head;
    // 尾节点
    private Node<T> tail;

    /**
     * 实现从头部添加元素
     *
     * @param value
     */
    private void addFromHead(T value) {
        Node<T> node = new Node<>(value);
        // 如果当前没有元素,直接把添加进的元素指定为头节点和尾节点
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // 更新 head 的前一个指针为当前的 node
            head.pre = node;
            // node 的 next 指针指向 head，到这里就实现两端都链接
            node.next = head;
            // 更新 head 的引用
            head = node;
        }
    }

    /**
     * 实现从尾部添加元素
     *
     * @param value
     */
    private void addFromTail(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            // 如果已经存在元素，tail 的 next 指针指向当前的 node 节点
            tail.next = node;
            // node 的 pre 指针也要指向 tail 这样才能实现两端链接
            node.pre = tail;
        }
        // 最后更新 tail 的引用
        tail = node;
    }

    /**
     * 从头部删除
     *
     * @return
     */
    private T deleteFromHead() {
        if (head == null) {
            // 如果 head 节点为空的话直接返回 null
            return null;
        }
        Node<T> node = head;
        // 需要判断时候只有一个元素，避免 ===== 处发生 npe
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // 更新 head 的引用，但是如果只有一个元素，这时 head 已经等于 null 了，造成后面 head.pre = null; 出现空指针
            head = head.next;
            // head 的 pre 指针清除，便于垃圾回收
            head.pre = null; // ===== 如果前面不判断 head == tail 的话，这里会发生 npe
        }
        return node.value;
    }

    /**
     * 从尾部删除
     *
     * @return
     */
    private T deleteFromTail() {
        if (head == null) {
            return null;
        }
        Node<T> node = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // 更新 tail 的指向引用
            tail = tail.pre;
            // 便于垃圾回收
            tail.next = null;
        }
        return node.value;
    }


    /**
     * 双向链表节点的定义
     *
     * @param <T>
     */
    private static class Node<T> {
        // 节点值
        private T value;
        // 下一个指针
        private Node<T> next;
        // 上一个指针
        private Node<T> pre;

        public Node(T value) {
            this.value = value;
        }
    }
}
