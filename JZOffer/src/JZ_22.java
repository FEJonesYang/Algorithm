/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-13
 * <p>
 * 返回链表倒数的第k个节点：第一遍计算链表节点的个数，第二遍返回倒数的第k个
 */
public class JZ_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //首先判断头节点是否为空
        if (head == null) return null;

        //首先计算出链表的长度
        ListNode temp = head;
        int cnt = 0;
        while (temp.next != null) {
            temp = temp.next;
            cnt++;
        }
        //循环遍历直到倒数第k个节点
        ListNode cur = head;
        int count = 0;
        while ((cnt - count + 1) != k) {
            cur = cur.next;
            count++;
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
