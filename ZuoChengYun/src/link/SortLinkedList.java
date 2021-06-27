package link;

import javax.sound.midi.MidiFileFormat;
import java.util.Arrays;

/**
 * @Author: JonesYang
 * @Data: 2021-06-27
 * @Description:对单向链表进行划分，按照左边小，中间相等，右边大的情况进行划分--两种方法
 */
public class SortLinkedList {
    /**
     * 需要一个辅助数组，把链表里的元素放到数组里，对数组进行排序，
     * 然后再串起来
     *
     * @param head
     * @param pivot
     * @return
     */
    private Node listPartition(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        // 计算链表的长度
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        // 把链表元素放进数组里
        int[] arr = new int[count + 1];
        cur = head;
        count = 0;
        while (cur != null) {
            arr[count++] = cur.value;
            cur = cur.next;
        }
        // 数组排序
        Arrays.sort(arr);
        // 把数组串起来，返回数组的第一个节点
        Node newHead = new Node(arr[0]);
        cur = newHead;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        return newHead;
    }

    /**
     * 不需要创建额外的空间，思路如下：
     * 把整个链表分成三个区域，小于区域、等于区域以及大于的区域
     *
     * @param head
     * @param pivot
     * @return 排好之后的新的头节点
     */
    private static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        // <
        Node sH = null;
        Node sT = null;
        // =
        Node eH = null;
        Node eT = null;
        // >
        Node mH = null;
        Node mT = null;

        // 对链表的元素进行分区存放
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.value < pivot) {
                // 如果是第一次插入元素
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = sT.next;
                }
            } else if (cur.value == pivot) {
                // 如果是第一次插入元素
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = eT.next;
                }
            } else {
                // 如果是第一次插入元素
                if (mH == null) {
                    mH = cur;
                    mT = cur;
                } else {
                    mT.next = cur;
                    mT = mT.next;
                }
            }
            cur = next;
        }

        // 最后把每一个区连起来，小于区的尾巴链接等于区的头，等于区的尾巴链接大于区域的头
        if (sH != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT; // 下一步谁去连大于区域的头
        }
        if (eT != null) {
            eT.next = mH;
        }

        return sH != null ? sH : (eH != null ? eH : mH);
    }

    /**
     * 链表节点数据结构
     */
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
