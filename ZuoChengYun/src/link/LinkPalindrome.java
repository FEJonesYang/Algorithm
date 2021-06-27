package link;

import java.util.Stack;

/**
 * @Author: JonesYang
 * @Data: 2021-06-27
 * @Description: 判断链表是不是回文链表，两种方法
 */
public class LinkPalindrome {

    /**
     * 使用辅助栈，额外的空间复杂度为O(N)
     *
     * @param head
     * @return
     */
    private boolean isPalindrome(Node head) {
        // 如果没有节点，或者只有一个节点，直接返回true
        if (head == null || head.next == null) {
            return true;
        }
        // 建立一个辅助栈
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        // 把链表的所有元素压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 再一次遍历链表，观察链表遍历到的元素和栈顶的元素是否相等
        cur = head;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 不要使用辅助栈，需要使用快慢指针
     *
     * @param head
     * @return
     */
    private boolean isPalindrome1(Node head) {
        // 如果没有节点，或者只有一个节点，直接返回true
        if (head == null || head.next == null) {
            return true;
        }
        // 得到链表的中点的节点
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 对链表的后半部分进行反转
        fast = slow.next;
        slow.next = null;
        Node n3 = null;
        while (fast != null) {
            n3 = fast.next;
            fast.next = slow;
            slow = fast;
            fast = n3;
        }
        // 记录链表的最后一个节点
        n3 = slow;
        fast = head;
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.value != fast.value) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        // 开始对链表的后半部分进行反转回来,再返回
        slow = n3.next;
        n3.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = n3;
            n3 = slow;
            slow = fast;
        }
        return res;
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
