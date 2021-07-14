package link.solution;

/**
 * @Author: JonesYang
 * @Data: 2021-07-13
 * @Description: 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 记录新节点
        ListNode newHead = new ListNode(-1);
        // 两个交换的节点
        ListNode pre = newHead;
        ListNode curL = head;
        ListNode curR = head.next;
        // 记录当前节点的下一个节点
        ListNode next;


        while (curR != null) {
            // 记录，防止引用丢失
            next = curR.next;

            // 交换
            pre.next = curR;
            curL.next = next;
            curR.next = curL;

            // 迭代
            pre = curL;
            if (next != null) {
                curL = next;
                curR = next.next;
            } else {
                break;
            }

        }

        return newHead.next;
    }

    //数组转成链表
    private static ListNode convertLink(int[] arr) {
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
