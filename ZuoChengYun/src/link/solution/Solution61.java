package link.solution;

/**
 * @Author: JonesYang
 * @Data: 2021-07-14
 * @Description: 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表的长度
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        // 倒数第 n 个节点处断开
        int n = k % size;

        // 如果 n == 0，这说明不需要旋转
        if (n == 0) {
            return head;
        }

        ListNode pre = head;
        cur = head;

        // 快指针先跑 n 步
        while (n != 0) {
            n--;
            cur = cur.next;
        }

        // 找到了倒数的第 n 个节点
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        // 记录新的头节点
        ListNode newHead = pre.next;
        // 成环
        cur.next = head;
        // 断开那个链接
        pre.next = null;

        return newHead;
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
