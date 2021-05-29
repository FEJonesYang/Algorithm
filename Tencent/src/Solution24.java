/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-24
 * <p>
 * . 两两交换链表中的节点
 */
public class Solution24 {

    /**
     * 迭代解法，对整个链表进行遍历
     */
    public ListNode swapPairs1(ListNode head) {
        // 定义一个额外的节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {
            // 需要交换的左节点
            ListNode left = cur.next;
            // 需要交换的右节点
            ListNode right = cur.next.next;

            // 开始进行交换，这是这道题的核心
            cur.next = right;
            left.next = right.next;
            right.next = left;
            // 更新 cur 的节点，进行下一次的交换
            cur = cur.next.next;
        }
        return pre.next;
    }

    /**
     * 递归解法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
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