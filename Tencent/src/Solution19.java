/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-14
 * <p>
 * 删除链表中倒数第的 n 个节点
 * <p>
 * 思路：两个遍历，第一个遍历确定 n 的位置，第二个遍历删除节点返回头节点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        // 如果删除的是头节点
        if (n == cnt) {
            return head.next;
        }
        cur = head;
        int count = 0;
        while (cur != null) {
            // 如果遍历达到相应的位置，进行删除操作
            if (++count == (cnt - n)) {
                ListNode temp = cur.next.next;
                cur.next.next = null;
                cur.next = temp;
            }
            cur = cur.next;
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
