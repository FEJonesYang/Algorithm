package link;

/**
 * @Author: JonesYang
 * @Data: 2021-06-27
 * @Description:双指针中的快慢指针
 */
public class SlowAndFastPointerReturnMid {
    /**
     * @param head
     * @return 奇数返回中点，偶数返回上中点
     */
    private Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 三个以及三个节点以上
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * @param head
     * @return 奇数返回中点，偶数返回下中点
     */
    private Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 三个以及三个节点以上
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * @param head
     * @return 奇数返回中点前一个节点，偶数返回上中点的前一个节点
     */
    private Node midPreOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 三个以及三个节点以上
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * @param head
     * @return 奇数返回中点前一个节点，偶数返回上中点的前一个节点
     */
    private Node midPreOrDownMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 三个以及三个节点以上
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 链表节点的数据结构
     */
    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
