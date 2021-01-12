import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 从头到尾打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Author: JonesYang
 * @Data: 2021-01-12
 */


public class JZ_06 {

    /**
     * 相对简单的思路：外部开辟一个容器，对链表进行遍历并添加到容器，利用容器的本身的
     * API进行反转。
     */
    private int[] reversePrint_Method_1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            //节点值添加到集合
            list.add(node.val);
            //进行后续的迭代
            node = node.next;
        }
        //对集合进行反转
        Collections.reverse(list);
        //定义一个 int 类型的数组，把集合中的数字添加到数组中
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    /**
     * 递归法：递归到链表的末尾，然后再把节点值添加到列表，最后一次返回
     * 由于遍历了N次，时间复杂度为 O(N)
     */
    List<Integer> temp = new ArrayList<>();

    private int[] reversePrint_Method_2(ListNode head) {
        recur(head);
        //定义一个 int 类型的数组，把集合中的数字添加到数组中
        int[] arr = new int[temp.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }

    // 递归函数
    private void recur(ListNode node) {
        if (node == null)
            return;
        recur(node.next);
        temp.add(node.val);
    }


    /**
     * 链表节点定义
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
