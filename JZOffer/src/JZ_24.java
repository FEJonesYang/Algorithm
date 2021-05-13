/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-13
 * <p>
 * 反转链表,双指针
 */
public class JZ_24 {
    public ListNode reverseList(ListNode head) {
        // 合法性校验
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = null;
        ListNode temp = null;
        while (pre != null) {
            //每次改变之前都需要把 pre 前一个节点存下来
            temp = pre.next;
            // 开始变化
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

