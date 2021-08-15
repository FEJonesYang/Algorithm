package tree;

/**
 * @Author: JonesYong
 * @Data: 2021-08-15
 * @Description: 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // 递归调用左子树，作为一个临时的节点
        TreeNode temp = invertTree(root.left);
        // 翻转
        root.left = invertTree(root.right);
        root.right = temp;
        // 最后返回根节点
        return root;
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
