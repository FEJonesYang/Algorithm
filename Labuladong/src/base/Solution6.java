package base;

/**
 * 链表实现栈
 */
public class Solution6<T> {

    Node<T> head = null;

    int size = 0;

    public Solution6() {
        this.head = new Node<>();
    }

    public T peek() {
        if (head.next == null) {
            return null;
        }
        return head.next.value;
    }

    public T pop() {
        if (head.next == null) {
            return null;
        }
        T value = head.next.value;
        head.next = head.next.next;
        size++;
        return value;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head.next;
        head.next = newNode;
        size--;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {

        }
    }

    private void printList(Node<T> node) {
        while (node.next != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println(node.value);

        System.out.println();
    }

    public static void main(String[] args) {
        Solution6<Integer> s = new Solution6<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.printList(s.head.next);

        System.out.println(s.peek());

        s.pop();
        s.printList(s.head.next);
    }
}
