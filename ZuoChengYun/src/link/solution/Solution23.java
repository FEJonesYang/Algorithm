package link.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: JonesYong
 * @Data: 2021-08-18
 * @Description: 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Solution23 {

    /**
     * 整体思路：把所有的链表串起来，串成数组，然后在一次一次创建节点
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> arr = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                arr.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(arr);
        if (arr.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(arr.get(0));
        ListNode cur = head;
        for (int i = 1; i < arr.size(); i++) {
            cur.next = new ListNode(arr.get(i));
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
