/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 *
 * 创建一个头节点，还有一个当前的 cur，遍历链表，直到链表为空。其中需要考虑到进位的问题，以及链表遍历完成之后，
 * 对于最后的进位进行存储
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int temp = 0; // 进位
        // 遍历链表，直到链表的节点为空
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();
            // l1 != null
            if (l1 != null) {
                // 如果l2 也不为null
                if (l2 != null) {
                    node.val = l2.val + l1.val + temp;
                } else {
                    node.val = l1.val + temp;
                }
            } else {
                node.val = l2.val + temp;
            }
            // 每一次进行加法操作后，都需要对进位清零
            temp = 0;
            // 对进位操作，node 的值超过了10，需要存储下一个进位
            if (node.val >= 10) {
                temp = node.val / 10;
                node.val = node.val % 10;
            }
            // 赋值值创建的节点，
            cur.next = node;
            cur = cur.next;
            // 开始进行下一轮迭代
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
        }
        // 对最后的进位进行处理
        if (temp != 0) {
            ListNode node = new ListNode(temp);
            cur.next = node;
        }

        return head.next;
    }

    // 链表节点定义
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
