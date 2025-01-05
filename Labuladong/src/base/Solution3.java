package base;

/**
 * 双链表实现动态集合
 */
public class Solution3<E> {

    public Node<E> head;
    public Node<E> tail;

    public Solution3() {
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public Solution3(Node<E> h) {
        this.head = new Node<>();
        this.tail = new Node<>();

        this.head.next = h;
        h.pre = this.head;

        Node<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = this.tail;
        this.tail.pre = cur;
    }

    /**
     * 尾部添加
     *
     * @param e
     */
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        newNode.next = this.tail;
        newNode.pre = this.tail.pre;

        this.tail.pre.next = newNode;
        this.tail.pre = newNode;
    }

    /**
     * 从头部添加
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        newNode.next = this.head.next;
        newNode.pre = this.head;

        this.head.next.pre = newNode;
        this.head.next = newNode;
    }

    /**
     * 从尾部删除
     *
     * @return
     */
    public E remove() {
        if (head.next == this.tail) {
            return null;
        }

        Node<E> r = this.tail.pre;

        r.pre.next = this.tail;
        this.tail.pre = r.pre;

        return r.value;
    }

    /**
     * 从头部删除
     *
     * @return
     */
    public E removeFirst() {
        if (head.next == this.tail) {
            return null;
        }

        Node<E> r = this.head.next;

        this.head.next = r.next;
        r.next.pre = this.head;

        return r.value;
    }

    private static <E> Node<E> createLinkedList(E[] arr) {
        Node<E> head = new Node<>(arr[0]);
        Node<E> cur = head, prev = null;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node<>(arr[i]);
            cur.pre = prev;

            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    private static <E> void printLinkedList(Node<E> head) {
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print(head.value);

        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList(new Integer[]{1, 2, 3, 4, 5});
        Solution3<Integer> s = new Solution3<>(head);

        // 初始化状态
        printLinkedList(s.head);

        // 验证add
        s.add(6);
        printLinkedList(s.head);

        // 验证addFirst
        s.addFirst(0);
        printLinkedList(s.head);

        // 验证remove
        s.remove();
        printLinkedList(s.head);

        // 验证removeFirst
        s.removeFirst();
        printLinkedList(s.head);
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> pre;

        public Node(E value) {
            this.value = value;
        }

        public Node() {

        }
    }

}
