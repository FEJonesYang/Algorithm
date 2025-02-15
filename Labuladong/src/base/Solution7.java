package base;

/**
 * 链表实现队列 (双链表)
 */
public class Solution7<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public Solution7() {
        head = new Node<>();
        tail = new Node<>();

        head.next = tail;
        tail.pre = head;
    }

    public T peek() {
        if (head.next == tail) {
            return null;
        }
        return tail.pre.value;
    }

    public T remove() {
        if (head.next == tail) {
            return null;
        }
        T value = tail.pre.value;

        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;

        size--;
        return value;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        newNode.pre = head;
        newNode.next = head.next;

        head.next.pre = newNode;
        head.next = newNode;

        size++;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> pre;

        public Node(T value) {
            this.value = value;
        }

        public Node() {

        }
    }

    private void printList(Node<T> node) {
        if (head.next == tail) {
            return;
        }
        Node<T> cur = node;
        for (int i = 0; i < size - 1; i++) {
            if (cur == head) {
                cur = cur.next;
            }
            if (cur == tail) {
                break;
            }
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.print(cur.value);

        System.out.println();
        System.out.println("size is: " + size);
    }

    public static void main(String[] args) {
        Solution7<Integer> s = new Solution7<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.printList(s.head);

        System.out.println("peek is: " + s.peek());

        s.remove();
        s.printList(s.head);
    }
}
