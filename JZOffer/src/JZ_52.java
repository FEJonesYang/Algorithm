
/**
 * @Author: JonesYang
 * @Data: 2021-07-09
 * @Description: 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 注意这两个链表可能没有公共的节点
 */
public class JZ_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        // 和判断链表是否有环很相似
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
                continue;
            }
            if (curB == null) {
                curB = headA;
                continue;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
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
