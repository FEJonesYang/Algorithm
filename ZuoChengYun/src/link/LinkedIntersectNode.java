package link;

/**
 * @Author: JonesYang
 * @Data: 2021-06-27
 * @Description: 给定两个可能有环，也可能无环的单链表，它们的头节点分别是 head1 和 head2，请实现一个函数，
 * 如果两个链表相交，请返回相交的第一个节点，如果不相交，请返回 null。
 * <p>
 * 如果两个链表的长度之和为 N，时间复杂度请达到O(N),空间复杂度请达到O(1)
 */
public class LinkedIntersectNode {
    /**
     * @param head1
     * @param head2
     * @return 返回两个链表相交的第一个节点
     */
    private Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 如果两个链表都没有环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 不可能存在一个链表有环一个链表无环的情况
        // 如果两个链表都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 两个链表都有环，如果没有相交的话返回 null；如果相交的话返回第一个相交的节点
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    private Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;

        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;

            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur2 = cur2.next;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    /**
     * 两个单链表并且无环的情况下，返回相交的节点
     *
     * @param head1
     * @param head2
     * @return
     */
    private Node noLoop(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != cur2) {
            if (cur1 == null) cur1 = head2;
            if (cur2 == null) cur2 = head1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 判断链表是否有环:
     * 如果有环，找到相等的节点之后，快指针再从头开始一步一步地走，一定可以和慢指针在头节点相遇
     *
     * @param head
     * @return 如果链表有环，返回入环的节点；如果链表没有环，那么返回 null
     */
    private Node getLoopNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;
        // 如果有环，就会存在 fast = slow 的情况
        while (fast != slow) {
            //一旦有一个指针为 null
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果能执行到这一步，说明链表肯定是有环的
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        // 返回最后入环的节点
        return slow;
    }

    /**
     * 链表节点数据结构
     */
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

