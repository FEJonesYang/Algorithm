package link.solution;

/**
 * @Author: JonesYang
 * @Data: 2021-07-12
 * @Description: 2. 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    /**
     * 注意：这道题我输出的是正确的值，和题目要求有所区别
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return reverseLink(l2);
        if (l2 == null) return reverseLink(l1);

        int num = 0; // 进位
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode newCur = newHead;
        while (cur1 != null && cur2 != null) {
            newCur.next = new ListNode((num + cur1.val + cur2.val) % 10);
            num = (num + cur1.val + cur2.val) / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
            newCur = newCur.next;
        }

        if (cur1 != null) {
            newCur.next = cur1;
        }

        if (cur2 != null) {
            newCur.next = cur2;
        }

        // 处理还有进位的情况
        while (num > 0) {
            if (newCur.next != null) {
                // 这个 temp 是通过 debug 找到了，它的作用是防止 num = (num + newCur.next.val) / 10;
                // 对 newCur.next.val = (temp + newCur.next.val) % 10; 产生影响
                int temp = num;
                num = (num + newCur.next.val) / 10;
                newCur.next.val = (temp + newCur.next.val) % 10;
                newCur = newCur.next;
            } else {
                newCur.next = new ListNode(num);
                break;
            }
        }
        return reverseLink(newHead.next);
    }

    // 反转链表
    private ListNode reverseLink(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre.next;
    }

    //数组转成链表
    private ListNode convertLink(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
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
