package link.solution;

/**
 * @Author: JonesYang
 * @Data: 2021-07-12
 * @Description: 19. 删除链表的倒数第 N 个结点
 * <p>
 * 你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
    /**
     * 双指针，一个指针先跑 n 步，这样当快指针到达的尾端的时候，慢指针刚好到达倒数的第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode left = pre;
        ListNode right = pre;

        // 快指针先走 n 步，使得快慢指针的间距为 n
        while (n != 0) {
            right = right.next;
            n--;
        }

        // 由于要删除的慢指针这个的节点，所以应该记录它的上一个节点，
        // 这个时候循环的条件 right.next != null 而不是 right != null
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        // 删除倒数第 n 个节点
        left.next = left.next.next;

        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
