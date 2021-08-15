package tree;

/**
 * @Author: JonesYong
 * @Data: 2021-08-15
 * @Description:114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution114 {


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 递归处理它的左右孩子
        flatten(root.left);
        flatten(root.right);

        // 左右孩子递归处理完，该处理root节点本身了，现在的问题是如何把
        // root的right指针指向左孩子，然后左孩子的right指针指向右孩子
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 左子树作为右子树
        root.left = null;
        root.right = left;

        // 把原来的右子树移到现在的右子树的右边
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
