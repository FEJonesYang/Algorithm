/**
 * @Author: JonesYang
 * @Data: 2021-07-11
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class JZ_36 {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        // 特殊值判断
        if (root == null) {
            return null;
        }
        recur(root);
        // 处理成环的情况
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(Node cur) {
        // base
        if (cur == null) {
            return;
        }
        // 递归左子树
        recur(cur.left);
        // 本层数据的处理
        if (pre != null) {
            pre.right = cur;
        } else {
            // 用于第一次时找到头节点
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        // 递归右子树
        recur(cur.right);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
