package tree;

/**
 * @Author: JonesYong
 * @Data: 2021-08-15
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 两个节点相等，只有在他们都为空的情况下才相等，否则在树的遍历过程中不可能出现节点相等的情况
        if (left == right) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // 他们的节点的值不相等
        if (left.val != right.val) {
            return false;
        }
        // 开始下一轮递归
        return dfs(left.left, right.right) && dfs(left.right, right.left);
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
