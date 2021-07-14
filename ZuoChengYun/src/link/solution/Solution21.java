package link.solution;

/**
 * @Author: JonesYang
 * @Data: 2021-07-12
 * @Description: 合并有序的链表
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode newCur = newHead;

        // 当这两个链表都没有结束的时候
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newCur.next = cur1;
                cur1 = cur1.next;
            } else {
                newCur.next = cur2;
                cur2 = cur2.next;
            }
            newCur = newCur.next;
        }

        // 如果这两个链表其中一个为null
        if (cur1 != null) {
            newCur.next = cur1;
        }
        if (cur2 != null) {
            newCur.next = cur2;
        }

        return newHead.next;
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
