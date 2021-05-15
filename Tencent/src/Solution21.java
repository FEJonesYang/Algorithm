/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-15
 * <p>
 * 合并两个有序的链表
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 输入参数的校验
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 用于记录，l1 l2 的位置，其实不用这两个也可以，直接在原来的基础上更新
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        // 创建一个链表，并返回它的下一个节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (cur1 != null || cur2 != null) {
            // 如果当前的节点都不为空
            if (cur1 != null && cur2 != null) {

                // 如果 l1 的节点小于 l2 的节点，需要在纸上画出下面的运行步骤，很好理解
                if (cur1.val <= cur2.val) {
                    // 创建节点记录当前移除的节点
                    ListNode temp = cur1;
                    // 更新 cur1
                    cur1 = cur1.next;
                    // 自己创建的节点指向移除的那个节点
                    cur.next = temp;
                    // 更新自己创建的链表的节点
                    cur = cur.next;
                    temp.next = null;
                } else {
                    ListNode temp = cur2;
                    cur2 = cur2.next;
                    cur.next = temp;
                    cur = cur.next;
                    temp.next = null;
                }

            } else if (cur1 != null && cur2 == null) {
                cur.next = cur1;
                break;
            } else { // cur1 == null && cur2 != null
                cur.next = cur2;
                break;
            }
        }

        return head.next;
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
