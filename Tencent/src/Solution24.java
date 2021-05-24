/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-24
 * <p>
 * . 两两交换链表中的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode temp = pre;
        }

        return head;
    }

    public class ListNode {
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