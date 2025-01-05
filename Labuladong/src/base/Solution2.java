package base;

/**
 * 单链表实现动态集合
 */
public class Solution2<E> {

    public Node<E> head;

    public Solution2() {
    }

    /**
     * 尾部添加
     *
     * @param e
     */
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * 从头部添加
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
    }


    /**
     * 从尾部删除
     *
     * @return
     */
    public E remove() {
        if (head.next == null) {
            return null;
        }

        Node<E> cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        Node<E> n = cur.next;
        cur.next = null;
        return n.value;
    }

    /**
     * 从头部删除
     *
     * @return
     */
    public E removeFirst() {
        if (head.next == null) {
            return null;
        }
        Node<E> r = head;
        head = head.next;
        return r.value;
    }

    private static <E> Node<E> createLinkedList(E[] arr) {
        Node<E> head = new Node<>(arr[0]);
        Node<E> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node<>(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution2<Integer> s = new Solution2<Integer>();
        s.head = createLinkedList(new Integer[]{1, 2, 3, 4, 5});

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

    private static <E> void printLinkedList(Node<E> head) {
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print(head.value);

        System.out.println();
    }


    public static class Node<E> {
        E value;

        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node() {
        }
    }
}
