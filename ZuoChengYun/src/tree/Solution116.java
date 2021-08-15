package tree;

/**
 * @Author: JonesYong
 * @Data: 2021-08-15
 * @Description:116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution116 {

    /**
     * 思路：当遍历到一个节点的时候，应该需要注意一下几个地方：
     * 1.这个节点是否存在孩子节点，如果存在，则把做孩子指向右孩子。
     * 2.需要把左孩子的右孩子以及右孩子的左孩子进行记录
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        // base case
        if (root == null) {
            return null;
        }
        // 增加一个辅助函数，将每一层的二叉树链接起来
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        // 如果这一行没有节点
        if (left == null) {
            return;
        }
        // 改变 next 的指向
        left.next = right;

        // 递归链接两个孩子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        // 链接这一层的节点
        connectTwoNode(left.right, right.left);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
