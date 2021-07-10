import java.util.List;

/**
 * @Author: JonesYang
 * @Data: 2021-07-11
 * @Description:
 */
public class JZ_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base 的基本判断
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 定义两个额外的指针，不直接对头节点进行操作
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        // 重新定义的一个新的节点，和当前的指针数据
        ListNode newHead = new ListNode(-1);
        ListNode newCur = newHead;
        // 如果两个链表都不违背空
        while (cur1 != null && cur2 != null) {
            ListNode next;
            if (cur1.val < cur2.val) {
                next = cur1.next;
                newCur.next = cur1;
                cur1 = next;
            } else {
                next = cur2.next;
                newCur.next = cur2;
                cur2 = next;
            }
            newCur = newCur.next;
        }
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

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
